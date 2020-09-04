package com.kgc.client;


import com.kgc.pojo.Invitation_invitation;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "sport-invitation-provider")
public interface Invitation_invitationClient {
    //分页，模糊查询的条件有帖子标题，发布者昵称，点赞数，推荐数，浏览数，发布时间
    //可以根据点赞数，推荐数，浏览数，发布时间 降序排列
    @RequestMapping("/getTb_invitationPage")
    public PageUtil getTb_invitationPage(@RequestParam Map<String, Object> map);
    //根据帖子编号查询某一个帖子信息
    @RequestMapping("/getTb_invitationById/{id}")
    public Invitation_invitation getTb_invitationById(@PathVariable("id") Integer id);
    //添加新的帖子
    @RequestMapping("/addTb_invitation")
    public int addTb_invitation(@RequestBody Invitation_invitation invitation);
    //更新帖子信息
    @RequestMapping("/updateTb_invitation")
    public int updateTb_invitation(@RequestBody Invitation_invitation invitation);
    //根据帖子ID更新帖子点赞数
    @RequestMapping("/updateSnum/{id}")
    public int updateSnum(@PathVariable("id")  Integer id);
    //根据帖子ID更新帖子推荐数
    @RequestMapping("/updateRnum/{id}")
    public int updateRnum(@PathVariable("id") Integer id);
    //根据帖子ID更新帖子浏览数
    @RequestMapping("/updateSeenum/{id}")
    public int updateSeenum(@PathVariable("id") Integer id);
    //据ID删除某个帖子
    @RequestMapping("/deleteTb_invitation/{id}")
    public int deleteTb_invitation(@PathVariable("id") Integer id);
    @RequestMapping("/init")
    public void initAssBRedis();
    @RequestMapping("/lockGoods")
    public int lockGoods(@RequestParam(value="invid",required = false,defaultValue = "1") Integer invid,
                         @RequestParam(value="userid",required = false,defaultValue = "1")  Integer userid);
}
