package com.kgc.service;

import com.kgc.mapper.Tb_invitationMapper;
import com.kgc.pojo.Invitation_area;
import com.kgc.pojo.Invitation_invitation;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestInvitation_invitationService {
    @Autowired
    private Tb_invitationMapper tb_invitationMapper;

    @RequestMapping("/getTb_invitationPage")
    public PageUtil getTb_invitationPage(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
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
    public Invitation_invitation getTb_invitationById(@PathVariable("id") Integer id){
        return tb_invitationMapper.getTb_invitationById(id);
    }

    //添加新的帖子
    @RequestMapping("/addTb_invitation")
    public int addTb_invitation(@RequestBody Invitation_invitation invitation){
        return tb_invitationMapper.addTb_invitation(invitation);
    }

    //更新帖子信息
    @RequestMapping("/updateTb_invitation")
    public int updateTb_invitation(@RequestBody Invitation_invitation invitation){
        return tb_invitationMapper.updateTb_invitation(invitation);
    }

    //根据帖子ID更新帖子点赞数
    @RequestMapping("/updateSnum/{id}")
    public int updateSnum(@PathVariable("id") Integer id){
        return tb_invitationMapper.updateSnum(id);
    }

    //根据帖子ID更新帖子推荐数
    @RequestMapping("/updateRnum/{id}")
    public int updateRnum(@PathVariable("id") Integer id){
        return tb_invitationMapper.updateRnum(id);
    }

    //根据帖子ID更新帖子浏览数
    @RequestMapping("/updateSeenum/{id}")
    public int updateSeenum(@PathVariable("id") Integer id){
        return tb_invitationMapper.updateSeenum(id);
    }

    //据ID删除某个帖子
    @RequestMapping("/deleteTb_invitation/{id}")
    public int deleteTb_invitation(@PathVariable("id") Integer id){
        return tb_invitationMapper.deleteTb_invitation(id);
    }
}
