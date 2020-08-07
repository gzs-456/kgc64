package com.kgc.service;

import com.kgc.mapper.Tb_areaMapper;
import com.kgc.pojo.Invitation_area;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Invitation_areaService {
    @Autowired
    private Tb_areaMapper tb_areaMapper;

    //分页,根据专区名称查询所有
    @RequestMapping("/getTb_areaPage")
    public PageUtil getTb_areaPage(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = tb_areaMapper.getCount(map);
        page.setTotalCount(count);
        //调用mapper方法
        List<Invitation_area> list = tb_areaMapper.getTb_areaPage(map);
        page.setList(list);
        return page;
    }

    //帖子表，专区表两表连接查询,根据帖子编号查询所有专区
    @RequestMapping("/getAreaByinvitationId/{invitationId}")
    public List<Invitation_area> getByinvitationId(@PathVariable("invitationId") Integer invitationId){
        return tb_areaMapper.getByinvitationId(invitationId);
    }

    //根据专区编号查询某一个专区介绍信息
    @RequestMapping("/getTb_areaById/{id}")
    public Invitation_area getTb_areaById(@PathVariable("id") Integer id){
        return tb_areaMapper.getTb_areaById(id);
    }

    //添加新的专区
    @RequestMapping("/addTb_area")
    public int addTb_area(@RequestBody Invitation_area area){
        return  tb_areaMapper.addTb_area(area);
    }

    //更新专区信息
    @RequestMapping("/updateTb_area")
    public int updateTb_area(@RequestBody Invitation_area area){
        return tb_areaMapper.updateTb_area(area);
    }

    //根据专区ID更新专区的点击数
    @RequestMapping("/updateAreaClicknum/{id}")
    public int updateClicknum(@PathVariable("id") Integer id){
        return tb_areaMapper.updateClicknum(id);
    }

    //根据ID删除某个专区
    @RequestMapping("/deleteTb_area/{id}")
    public int deleteTb_area(@PathVariable("id") Integer id){
        return tb_areaMapper.deleteTb_area(id);
    }
}
