package com.kgc.controller;

import com.kgc.pojo.Invitation_invitation;
import com.kgc.service.Invitation_invitationService;
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
@Api(value = "社交模块",description = "处理帖子")
public class Invitation_invitationController {
    @Autowired
    private Invitation_invitationService invitationService;

    /*
        分页，模糊查询的条件有帖子标题，发布者昵称，点赞数，推荐数，浏览数，发布时间
        可以根据点赞数，推荐数，浏览数，发布时间 降序排列
     */
    @RequestMapping("/getTb_invitationPage/{pageIndex}/{pageSize}")
    @ApiOperation(value = "分页",notes = "模糊查询的条件有帖子标题，发布者昵称，点赞数，推荐数，浏览数，发布时间\n" +
            "        可以根据点赞数，推荐数，浏览数，发布时间 降序排列")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "invitation", value = "帖子对象", required = false, dataType = "Invitation_invitation"),
            @ApiImplicitParam(name = "pageIndex", value = "页码默认为1", required = false, dataType = "Integer",paramType="path"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数默认为2", required = false, dataType = "Integer",paramType="path")
    })
    public PageUtil<Invitation_invitation> getTb_invitationPage(@RequestBody Invitation_invitation  invitation,
           @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
           @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize) {
        return invitationService.getTb_invitationPage(invitation,pageIndex,pageSize);
    }


    //根据帖子编号查询某一个帖子信息
    @RequestMapping("/getTb_invitationById/{id}")
    @ApiOperation(value = "查询某一个帖子信息",notes = "根据帖子编号查询某一个帖子信息")
    @ApiImplicitParam(name = "id", value = "帖子编号", required = false, dataType = "Integer",paramType="path")
    public Invitation_invitation getTb_invitationById(@PathVariable("id") Integer id){
        return invitationService.getTb_invitationById(id);
    }


    //添加新的帖子
    @RequestMapping("/addTb_invitation")
    @ApiOperation(value = "添加",notes = "添加新的帖子")
    @ApiImplicitParam(name = "invitation", value = "帖子对象", required = false, dataType = "Invitation_invitation")
    public int addTb_invitation(@RequestBody Invitation_invitation invitation) {
        return invitationService.addTb_invitation(invitation);
    }


    //更新帖子信息
    @RequestMapping("/updateTb_invitation")
    @ApiOperation(value = "更新",notes = "更新帖子信息")
    @ApiImplicitParam(name = "invitation", value = "帖子对象", required = false, dataType = "Invitation_invitation")
    public int updateTb_invitation(@RequestBody Invitation_invitation invitation) {
        return invitationService.updateTb_invitation(invitation);
    }


    //根据帖子ID更新帖子点赞数
    @RequestMapping("/updateSnum/{id}")
    @ApiOperation(value = "更新帖子点赞数",notes = "根据帖子ID更新帖子点赞数")
    @ApiImplicitParam(name = "id", value = "帖子编号", required = false, dataType = "Integer",paramType="path")
    public int updateSnum(@PathVariable("id") Integer id){
        return invitationService.updateSnum(id);
    }


    //根据帖子ID更新帖子推荐数
    @RequestMapping("/updateRnum/{id}")
    @ApiOperation(value = "更新帖子推荐数",notes = "根据帖子ID更新帖子推荐数")
    @ApiImplicitParam(name = "id", value = "帖子编号", required = false, dataType = "Integer",paramType="path")
    public int updateRnum(@PathVariable("id") Integer id){
        return invitationService.updateRnum(id);
    }


    //根据帖子ID更新帖子浏览数
    @RequestMapping("/updateSeenum/{id}")
    @ApiOperation(value = "更新帖子浏览数",notes = "根据帖子ID更新帖子浏览数")
    @ApiImplicitParam(name = "id", value = "帖子编号", required = false, dataType = "Integer",paramType="path")
    public int updateSeenum(@PathVariable("id") Integer id){
        return invitationService.updateSeenum(id);
    }


    //据ID删除某个帖子
    @RequestMapping("/deleteTb_invitation/{id}")
    @ApiOperation(value = "删除",notes = "据ID删除某个帖子")
    @ApiImplicitParam(name = "id", value = "帖子编号", required = false, dataType = "Integer",paramType="path")
    public int deleteTb_invitation(@PathVariable("id") Integer id){
        return invitationService.deleteTb_invitation(id);
    }
}
