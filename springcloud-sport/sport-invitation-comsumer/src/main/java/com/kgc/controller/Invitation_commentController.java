package com.kgc.controller;

import com.kgc.pojo.Invitation_comment;
import com.kgc.service.Invitation_commentService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class Invitation_commentController {
    @Autowired
    private Invitation_commentService commentService;
    //分页，帖子表，评论表两表连接查询,根据帖子编号查询所有评论
    @RequestMapping("/getTb_commentPage")
    public PageUtil<Invitation_comment> getTb_commentPage(Integer invitationId,
           @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
           @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize) {
        return commentService.getTb_commentPage(invitationId,pageIndex,pageSize);
    }
    //添加新的帖子评论
    @RequestMapping("/addTb_comment")
    public int addTb_comment(@RequestBody Invitation_comment comment){
        return commentService.addTb_comment(comment);
    }
    //更新帖子评论信息
    @RequestMapping("/updateTb_comment")
    public int updateTb_comment(@RequestBody Invitation_comment comment){
        return commentService.updateTb_comment(comment);
    }
    //根据帖子ID更新帖子评论的点赞数
    @RequestMapping("/updateCnum")
    public int updateCnum(Integer id){
        return commentService.updateCnum(id);
    }
    //根据ID删除某个帖子评论
    @RequestMapping("/deleteTb_comment")
    public int deleteTb_comment(Integer id){
        return commentService.deleteTb_comment(id);
    }
}
