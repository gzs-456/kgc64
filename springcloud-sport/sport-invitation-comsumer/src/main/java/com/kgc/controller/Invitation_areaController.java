package com.kgc.controller;

import com.kgc.pojo.Invitation_area;
import com.kgc.service.Invitation_areaService;
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
@Api(value = "社交模块",description = "处理专区")
public class Invitation_areaController {
    @Autowired
    private Invitation_areaService areaService;

    //分页,根据专区名称查询所有
    @RequestMapping("/getTb_areaPage/{pageIndex}/{pageSize}")
    @ApiOperation(value = "分页",notes = "根据专区名称查询所有，页码默认为1，每页条数默认为2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "areaname", value = "专区名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "pageIndex", value = "页码默认为1", required = false, dataType = "Integer",paramType="path"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数默认为2", required = false, dataType = "Integer",paramType="path")
    })
    public PageUtil<Invitation_area> getTb_areaPage(String areaname,
            @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize) {
        return areaService.getTb_areaPage(areaname,pageIndex,pageSize);
    }


    //帖子表，专区表两表连接查询,根据帖子编号查询所有专区
    @RequestMapping("/getAreaByinvitationId/{invitationId}")
    @ApiOperation(value = "帖子表，专区表两表连接查询",notes = "根据帖子编号查询所有专区")
    @ApiImplicitParam(name = "invitationId", value = "帖子编号", required = true, dataType = "Integer",paramType="path")
    public List<Invitation_area> getByinvitationId(@PathVariable("invitationId") Integer invitationId) {
        return areaService.getByinvitationId(invitationId);
    }


    //根据专区编号查询某一个专区介绍信息
    @RequestMapping("/getTb_areaById/{id}")
    @ApiOperation(value = "查询某一个专区介绍信息",notes = "根据专区编号查询某一个专区介绍信息")
    @ApiImplicitParam(name = "id", value = "专区编号", required = true, dataType = "Integer",paramType="path")
    public Invitation_area getTb_areaById(@PathVariable("id") Integer id){
        return areaService.getTb_areaById(id);
    }


    //添加新的专区
    @RequestMapping("/addTb_area")
    @ApiOperation(value = "添加",notes = "添加新的专区")
    @ApiImplicitParam(name = "area", value = "专区对象", required = true, dataType = "Invitation_area")
    public int addTb_area(@RequestBody Invitation_area area){
        return areaService.addTb_area(area);
    }


    //更新专区信息
    @RequestMapping("/updateTb_area")
    @ApiOperation(value = "更新",notes = "更新专区信息")
    @ApiImplicitParam(name = "area", value = "专区对象", required = true, dataType = "Invitation_area")
    public int updateTb_area(@RequestBody Invitation_area area){
        return areaService.updateTb_area(area);
    }


    //根据专区ID更新专区的点击数
    @RequestMapping("/updateAreaClicknum/{id}")
    @ApiOperation(value = "更新专区的点击数",notes = "根据专区ID更新专区的点击数")
    @ApiImplicitParam(name = "id", value = "专区编号", required = true, dataType = "Integer",paramType="path")
    public int updateClicknum(@PathVariable("id") Integer id){
        return areaService.updateClicknum(id);
    }


    //根据ID删除某个专区
    @RequestMapping("/deleteTb_area/{id}")
    @ApiOperation(value = "删除",notes = "根据ID删除某个专区")
    @ApiImplicitParam(name = "id", value = "专区编号", required = true, dataType = "Integer",paramType="path")
    public int deleteTb_area(@PathVariable("id") Integer id){
        return areaService.deleteTb_area(id);
    }
}
