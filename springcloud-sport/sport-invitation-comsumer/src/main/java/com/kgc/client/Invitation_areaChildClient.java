package com.kgc.client;


import com.kgc.pojo.Invitation_areaChild;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name="sport-invitation-provider")
public interface Invitation_areaChildClient {
    //分页,根据专区子版块名称查询所有
    @RequestMapping("/getTb_areaChildPage")
    public PageUtil getTb_areaChildPage(@RequestParam Map<String, Object> map);
    //帖子表，专区子版块表两表连接查询,根据帖子编号查询所有专区子版块
    @RequestMapping("/getAreaChildByinvitationId/{invitationId}")
    public List<Invitation_areaChild> getByinvitationId(@PathVariable("invitationId") Integer invitationId);
    //专区表，专区子版块表两表连接查询,根据专区编号查询所有专区子版块
    @RequestMapping("/getAreaChildByareaId/{areaId}")
    public List<Invitation_areaChild> getByareaId(@PathVariable("areaId") Integer areaId);
    //根据专区子版块编号查询某一个专区子版块介绍信息
    @RequestMapping("/getTb_areaChildById/{id}")
    public Invitation_areaChild getTb_areaById(@PathVariable("id") Integer id);
    //添加新的专区子版块
    @RequestMapping("/addTb_areaChild")
    public int addTb_areaChild(@RequestBody Invitation_areaChild areaChild);
    //更新专区子版块信息
    @RequestMapping("/updateTb_areaChild")
    public int updateTb_areaChild(@RequestBody Invitation_areaChild areaChild);
    //根据专区子版块ID更新专区子版块的点击数
    @RequestMapping("/updateAreaChildClicknum/{id}")
    public int updateClicknum(@PathVariable("id") Integer id);
    //根据ID删除某个专区子版块
    @RequestMapping("/deleteTb_areaChild/{id}")
    public int deleteTb_areaChild(@PathVariable("id") Integer id);
}
