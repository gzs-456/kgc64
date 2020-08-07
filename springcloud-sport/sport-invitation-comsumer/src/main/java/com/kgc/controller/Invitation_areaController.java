package com.kgc.controller;

import com.kgc.pojo.Invitation_area;
import com.kgc.service.Invitation_areaService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Invitation_areaController {
    @Autowired
    private Invitation_areaService areaService;
    //分页,根据专区名称查询所有
    @RequestMapping("/getTb_areaPage")
    public PageUtil<Invitation_area> getTb_areaPage(String areaname,
            @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize) {
        return areaService.getTb_areaPage(areaname,pageIndex,pageSize);
    }
    //帖子表，专区表两表连接查询,根据帖子编号查询所有专区
    @RequestMapping("/getAreaByinvitationId")
    public List<Invitation_area> getByinvitationId(Integer invitationId) {
        return areaService.getByinvitationId(invitationId);
    }
    //根据专区编号查询某一个专区介绍信息
    @RequestMapping("/getTb_areaById")
    public Invitation_area getTb_areaById(Integer id){
        return areaService.getTb_areaById(id);
    }
    //添加新的专区
    @RequestMapping("/addTb_area")
    public int addTb_area(@RequestBody Invitation_area area){
        return areaService.addTb_area(area);
    }
    //更新专区信息
    @RequestMapping("/updateTb_area")
    public int updateTb_area(@RequestBody Invitation_area area){
        return areaService.updateTb_area(area);
    }
    //根据专区ID更新专区的点击数
    @RequestMapping("/updateAreaClicknum")
    public int updateClicknum(Integer id){
        return areaService.updateClicknum(id);
    }
    //根据ID删除某个专区
    @RequestMapping("/deleteTb_area")
    public int deleteTb_area(Integer id){
        return areaService.deleteTb_area(id);
    }
}
