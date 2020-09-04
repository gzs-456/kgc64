package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.kgc.mapper.Tb_invitationMapper;
import com.kgc.pojo.InvitationRedis;
import com.kgc.pojo.Invitation_area;
import com.kgc.pojo.Invitation_invitation;
import com.kgc.util.PageUtil;
import com.kgc.util.RedisUtils;
import com.kgc.vo.InvitationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestInvitation_invitationService {
    @Autowired
    private Tb_invitationMapper tb_invitationMapper;
    @Autowired
    private RedisUtils redisUtils;

    //分页，模糊查询的条件有帖子标题，发布者昵称，点赞数，推荐数，浏览数，发布时间
    //可以根据点赞数，推荐数，浏览数，发布时间 降序排列
    @RequestMapping("/getTb_invitationPage")
    public PageUtil getTb_invitationPage(@RequestParam Map<String, Object> map) {
        PageUtil page = new PageUtil();
        //当前页面
        Integer pageIndex = Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = tb_invitationMapper.getCount(map);
        page.setTotalCount(count);
        //调用mapper方法
        List<Invitation_invitation> list = tb_invitationMapper.getTb_invitationPage(map);
        page.setList(list);
        return page;
    }

    //根据帖子编号查询某一个帖子信息
    @RequestMapping("/getTb_invitationById/{id}")
    public Invitation_invitation getTb_invitationById(@PathVariable("id") Integer id) {
        return tb_invitationMapper.getTb_invitationById(id);
    }

    //添加新的帖子
    @RequestMapping("/addTb_invitation")
    public int addTb_invitation(@RequestBody Invitation_invitation invitation) {
        return tb_invitationMapper.addTb_invitation(invitation);
    }

    //更新帖子信息
    @RequestMapping("/updateTb_invitation")
    public int updateTb_invitation(@RequestBody Invitation_invitation invitation) {
        return tb_invitationMapper.updateTb_invitation(invitation);
    }

    //根据帖子ID更新帖子点赞数
    @RequestMapping("/updateSnum/{id}")
    public int updateSnum(@PathVariable("id") Integer id) {
        return tb_invitationMapper.updateSnum(id);
    }

    //根据帖子ID更新帖子推荐数
    @RequestMapping("/updateRnum/{id}")
    public int updateRnum(@PathVariable("id") Integer id) {
        return tb_invitationMapper.updateRnum(id);
    }

    //根据帖子ID更新帖子浏览数
    @RequestMapping("/updateSeenum/{id}")
    public int updateSeenum(@PathVariable("id") Integer id) {
        return tb_invitationMapper.updateSeenum(id);
    }

    //据ID删除某个帖子
    @RequestMapping("/deleteTb_invitation/{id}")
    public int deleteTb_invitation(@PathVariable("id") Integer id) {
        return tb_invitationMapper.deleteTb_invitation(id);
    }


    //初始化
    @RequestMapping("/init")
    public void initAssBRedis() throws Exception {
        List<Invitation_invitation> list = tb_invitationMapper.getAllInvitation();
        //遍历，把商品放到redis中
        for (Invitation_invitation invitation : list) {
            String key = "Inv_" + invitation.getId();
            InvitationVo Inv = new InvitationVo();
            //属性拷贝
            BeanUtils.copyProperties(invitation, Inv);
            Inv.setTitle(invitation.getTitle());
            Inv.setCurrentCount(invitation.getSnum());
            Inv.setOldCount(invitation.getSnum());
            redisUtils.set(key, JSON.toJSONString(Inv));
        }
    }

    @RequestMapping("/lockGoods")
    public int lockGoods(@RequestParam(value="invid",required = false,defaultValue = "1") Integer invid,@RequestParam(value="userid",required = false,defaultValue = "1")  Integer userid) throws Exception {
        try {
            invid = 1;
            userid = 1;

            String key = "Inv_" + invid;
            String json = redisUtils.get(key).toString();
            InvitationVo ass = JSON.parseObject(json, InvitationVo.class);
            //商品抢购信息表添加抢购信息
            InvitationRedis ass_coll = new InvitationRedis();
            ass_coll.setInvid(invid);
            ass_coll.setUserid(userid);
            //更改库存量
            ass.setCurrentCount(ass.getCurrentCount() + 1);
            redisUtils.set(key, JSON.toJSONString(ass));
            System.out.println("收藏数...." + ass.getCurrentCount());
            //数据库添加
            tb_invitationMapper.addInvitation(invid, userid);
            tb_invitationMapper.updateSnum(invid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}
