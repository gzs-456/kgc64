package com.kgc.controller;

import com.kgc.pojo.Invitation_areaChild;
import com.kgc.service.Invitation_areaChildService;
import com.kgc.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/invitation")
@Api(value = "社交模块",description = "处理专区子版块")
public class Invitation_areaChildController {
    @Autowired
    private Invitation_areaChildService areaChildService;


    //分页,根据专区子版块名称查询所有
    @RequestMapping("/getTb_areaChildPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "areaname", value = "专区子版块名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "pageIndex", value = "页码默认为1", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数默认为2", required = false, dataType = "Integer")
    })
    @ApiOperation(value = "分页",notes = "根据专区子版块名称查询所有,页码默认为1，每页条数默认为2")
    public PageUtil<Invitation_areaChild> getTb_areaChildPage(String areaname,
            @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize) {
        return areaChildService.getTb_areaChildPage(areaname,pageIndex,pageSize);
    }


    //帖子表，专区子版块表两表连接查询,根据帖子编号查询所有专区子版块
    @RequestMapping("/getAreaChildByinvitationId")
    @ApiOperation(value = "帖子表，专区子版块表两表连接查询",notes = "根据帖子编号查询所有专区子版块")
    @ApiImplicitParam(name = "invitationId", value = "帖子编号", required = true, dataType = "Integer")
    public List<Invitation_areaChild> getAreaChildByinvitationId(Integer invitationId){
        return areaChildService.getByinvitationId(invitationId);
    }


    //专区表，专区子版块表两表连接查询,根据专区编号查询所有专区子版块
    @RequestMapping("/getAreaChildByareaId")
    @ApiOperation(value = "专区表，专区子版块表两表连接查询",notes = "根据专区编号查询所有专区子版块")
    @ApiImplicitParam(name = "areaId", value = "专区编号", required = true, dataType = "Integer")
    public List<Invitation_areaChild> getAreaChildByareaId(Integer areaId){
        return areaChildService.getByareaId(areaId);
    }


    //根据专区子版块编号查询某一个专区子版块介绍信息
    @RequestMapping("/getTb_areaChildById")
    @ApiOperation(value = "查询某一个专区子版块介绍信息",notes = "根据专区子版块编号查询某一个专区子版块介绍信息")
    @ApiImplicitParam(name = "id", value = "专区子版块编号", required = true, dataType = "Integer")
    public Invitation_areaChild getTb_areaChildById(Integer id){
        return areaChildService.getTb_areaById(id);
    }


    //添加新的专区子版块
    @RequestMapping("/addTb_areaChild")
    @ApiOperation(value = "添加",notes = "添加新的专区子版块")
    @ApiImplicitParam(name = "areaChild", value = "专区子版块实体对象", required = true, dataType = "Invitation_areaChild")
    public int addTb_areaChild(@RequestBody Invitation_areaChild areaChild){
        return areaChildService.addTb_areaChild(areaChild);
    }


    //更新专区子版块信息
    @RequestMapping("/updateTb_areaChild")
    @ApiOperation(value = "更新",notes = "更新专区子版块信息")
    @ApiImplicitParam(name = "areaChild", value = "专区子版块实体对象", required = true, dataType = "Invitation_areaChild")
    public int updateTb_areaChild(@RequestBody Invitation_areaChild areaChild) {
        return areaChildService.updateTb_areaChild(areaChild);
    }


    //根据专区子版块ID更新专区子版块的点击数
    @RequestMapping("/updateAreaChildClicknum")
    @ApiOperation(value = "更新专区子版块的点击数",notes = "根据专区子版块ID更新专区子版块的点击数")
    @ApiImplicitParam(name = "id", value = "专区子版块编号", required = true, dataType = "Integer")
    public int updateClicknum(Integer id){
        return areaChildService.updateClicknum(id);
    }


    //根据ID删除某个专区子版块
    @RequestMapping("/deleteTb_areaChild")
    @ApiOperation(value = "删除",notes = "根据ID删除某个专区子版块")
    @ApiImplicitParam(name = "id", value = "专区子版块编号", required = true, dataType = "Integer")
    public int deleteTb_areaChild(Integer id){
        return areaChildService.deleteTb_areaChild(id);
    }
}
