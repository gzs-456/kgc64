package com.kgc.controller;

import com.kgc.pojo.Invitation_comment;
import com.kgc.service.Invitation_commentService;
import com.kgc.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/invitation")
@Api(value = "社交模块",description = "处理帖子评论")
public class Invitation_commentController {
    @Autowired
    private Invitation_commentService commentService;


    //分页，帖子表，评论表两表连接查询,根据帖子编号查询所有评论
    @ApiOperation(value = "分页",notes = "帖子表，评论表两表连接查询,根据帖子编号查询所有评论")
    @RequestMapping("/getTb_commentPage/{invitationId}/{pageIndex}/{pageSize}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "invitationId", value = "帖子编号", required = false, dataType = "Integer",paramType="path"),
            @ApiImplicitParam(name = "pageIndex", value = "页码默认为1", required = false, dataType = "Integer",paramType="path"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数默认为2", required = false, dataType = "Integer",paramType="path")
    })
    public PageUtil<Invitation_comment> getTb_commentPage(@PathVariable("invitationId") Integer invitationId,
           @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
           @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize) {
        return commentService.getTb_commentPage(invitationId,pageIndex,pageSize);
    }


    //添加新的帖子评论
    @ApiOperation(value = "添加",notes = "添加新的帖子评论")
    @RequestMapping("/addTb_comment")
    @ApiImplicitParam(name = "comment", value = "评论对象", required = true, dataType = "Invitation_comment")
    public int addTb_comment(@RequestBody Invitation_comment comment){
        return commentService.addTb_comment(comment);
    }


    //更新帖子评论信息
    @RequestMapping("/updateTb_comment")
    @ApiOperation(value = "更新",notes = "更新帖子评论信息")
    @ApiImplicitParam(name = "comment", value = "评论对象", required = true, dataType = "Invitation_comment")
    public int updateTb_comment(@RequestBody Invitation_comment comment){
        return commentService.updateTb_comment(comment);
    }


    //根据帖子ID更新帖子评论的点赞数
    @RequestMapping("/updateCnum/{id}")
    @ApiOperation(value = "更新帖子评论的点赞数",notes = "根据帖子ID更新帖子评论的点赞数")
    @ApiImplicitParam(name = "id", value = "评论编号", required = true, dataType = "Integer",paramType="path")
    public int updateCnum(@PathVariable("id") Integer id){
        return commentService.updateCnum(id);
    }


    //根据ID删除某个帖子评论
    @RequestMapping("/deleteTb_comment/{id}")
    @ApiOperation(value = "删除",notes = "根据ID删除某个帖子评论")
    @ApiImplicitParam(name = "id", value = "评论编号", required = true, dataType = "Integer",paramType="path")
    public int deleteTb_comment(@PathVariable("id") Integer id){
        return commentService.deleteTb_comment(id);
    }
}
