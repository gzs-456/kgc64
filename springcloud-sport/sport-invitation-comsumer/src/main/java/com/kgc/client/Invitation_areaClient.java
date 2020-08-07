package com.kgc.client;


import com.kgc.pojo.Invitation_area;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "sport-invitation-provider")
public interface Invitation_areaClient {
    //分页,根据专区名称查询所有
    @RequestMapping("/getTb_areaPage")
    public PageUtil getTb_areaPage(@RequestParam Map<String, Object> map);
    //帖子表，专区表两表连接查询,根据帖子编号查询所有专区
    @RequestMapping("/getAreaByinvitationId/{invitationId}")
    public List<Invitation_area> getByinvitationId(@PathVariable("invitationId") Integer invitationId);
    //根据专区编号查询某一个专区介绍信息
    @RequestMapping("/getTb_areaById/{id}")
    public Invitation_area getTb_areaById(@PathVariable("id") Integer id);
    //添加新的专区
    @RequestMapping("/addTb_area")
    public int addTb_area(@RequestBody Invitation_area area);
    //更新专区信息
    @RequestMapping("/updateTb_area")
    public int updateTb_area(@RequestBody Invitation_area area);
    //根据专区ID更新专区的点击数
    @RequestMapping("/updateAreaClicknum/{id}")
    public int updateClicknum(@PathVariable("id") Integer id);
    //根据ID删除某个专区
    @RequestMapping("/deleteTb_area/{id}")
    public int deleteTb_area(@PathVariable("id") Integer id);
}
