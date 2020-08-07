package com.kgc.controller;

import com.kgc.pojo.Invitation_invitation;
import com.kgc.service.Invitation_invitationService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class Invitation_invitationController {
    @Autowired
    private Invitation_invitationService invitationService;
    //分页，模糊查询的条件有帖子标题，发布者昵称，点赞数，推荐数，浏览数，发布时间
    //可以根据点赞数，推荐数，浏览数，发布时间 降序排列
    @RequestMapping("/getTb_invitationPage")
    public PageUtil<Invitation_invitation> getTb_invitationPage(String title, String iname, String ftime, Integer snum, Integer rnum, Integer seenum,
           @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
           @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize) {
        return invitationService.getTb_invitationPage(title,iname,ftime,snum,rnum,seenum,pageIndex,pageSize);
    }
    //根据帖子编号查询某一个帖子信息
    @RequestMapping("/getTb_invitationById")
    public Invitation_invitation getTb_invitationById(Integer id){
        return invitationService.getTb_invitationById(id);
    }
    //添加新的帖子
    @RequestMapping("/addTb_invitation")
    public int addTb_invitation(@RequestBody Invitation_invitation invitation) {
        return invitationService.addTb_invitation(invitation);
    }
    //更新帖子信息
    @RequestMapping("/updateTb_invitation")
    public int updateTb_invitation(@RequestBody Invitation_invitation invitation) {
        return invitationService.updateTb_invitation(invitation);
    }
    //根据帖子ID更新帖子点赞数
    @RequestMapping("/updateSnum")
    public int updateSnum(Integer id){
        return invitationService.updateSnum(id);
    }
    //根据帖子ID更新帖子推荐数
    @RequestMapping("/updateRnum")
    public int updateRnum(Integer id){
        return invitationService.updateRnum(id);
    }
    //根据帖子ID更新帖子浏览数
    @RequestMapping("/updateSeenum")
    public int updateSeenum(Integer id){
        return invitationService.updateSeenum(id);
    }
    //据ID删除某个帖子
    @RequestMapping("/deleteTb_invitation")
    public int deleteTb_invitation(Integer id){
        return invitationService.deleteTb_invitation(id);
    }
}
