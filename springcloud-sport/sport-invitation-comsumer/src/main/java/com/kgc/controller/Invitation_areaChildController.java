package com.kgc.controller;

import com.kgc.pojo.Invitation_areaChild;
import com.kgc.service.Invitation_areaChildService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Invitation_areaChildController {
    @Autowired
    private Invitation_areaChildService areaChildService;
    //分页,根据专区子版块名称查询所有
    @RequestMapping("/getTb_areaChildPage")
    public PageUtil<Invitation_areaChild> getTb_areaChildPage(String areaname,
            @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize) {
        return areaChildService.getTb_areaChildPage(areaname,pageIndex,pageSize);
    }
    //帖子表，专区子版块表两表连接查询,根据帖子编号查询所有专区子版块
    @RequestMapping("/getAreaChildByinvitationId")
    public List<Invitation_areaChild> getAreaChildByinvitationId(Integer invitationId){
        return areaChildService.getByinvitationId(invitationId);
    }
    //专区表，专区子版块表两表连接查询,根据专区编号查询所有专区子版块
    @RequestMapping("/getAreaChildByareaId")
    public List<Invitation_areaChild> getAreaChildByareaId(Integer areaId){
        return areaChildService.getByareaId(areaId);
    }
    //根据专区子版块编号查询某一个专区子版块介绍信息
    @RequestMapping("/getTb_areaChildById")
    public Invitation_areaChild getTb_areaChildById(Integer id){
        return areaChildService.getTb_areaById(id);
    }
    //添加新的专区子版块
    @RequestMapping("/addTb_areaChild")
    public int addTb_areaChild(@RequestBody Invitation_areaChild areaChild){
        return areaChildService.addTb_areaChild(areaChild);
    }
    //更新专区子版块信息
    @RequestMapping("/updateTb_areaChild")
    public int updateTb_areaChild(@RequestBody Invitation_areaChild areaChild) {
        return areaChildService.updateTb_areaChild(areaChild);
    }
    //根据专区子版块ID更新专区子版块的点击数
    @RequestMapping("/updateAreaChildClicknum")
    public int updateClicknum(Integer id){
        return areaChildService.updateClicknum(id);
    }
    //根据ID删除某个专区子版块
    @RequestMapping("/deleteTb_areaChild")
    public int deleteTb_areaChild(Integer id){
        return areaChildService.deleteTb_areaChild(id);
    }
}
