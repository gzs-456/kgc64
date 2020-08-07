package com.kgc.service;

import com.kgc.mapper.Tb_areaChildMapper;
import com.kgc.pojo.Invitation_areaChild;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestInvitation_areaChildService {
    @Autowired
    private Tb_areaChildMapper tb_areaChildMapper;

    //分页,根据专区子版块名称查询所有
    @RequestMapping("/getTb_areaChildPage")
    public PageUtil getTb_areaChildPage(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = tb_areaChildMapper.getCount(map);
        page.setTotalCount(count);
        //调用mapper方法
        List<Invitation_areaChild> list = tb_areaChildMapper.getTb_areaChildPage(map);
        page.setList(list);
        return page;
    }

    //根据专区子版块编号查询某一个专区子版块介绍信息
    @RequestMapping("/getTb_areaById/{id}")
    public Invitation_areaChild getTb_areaById(@PathVariable("id") Integer id){
        return tb_areaChildMapper.getTb_areaById(id);
    }

    //添加新的专区子版块
    @RequestMapping("/addTb_areaChild")
    public int addTb_areaChild(@RequestBody Invitation_areaChild areaChild){
        return tb_areaChildMapper.addTb_areaChild(areaChild);
    }

    //更新专区子版块信息
    @RequestMapping("/updateTb_areaChild")
    public int updateTb_areaChild(@RequestBody Invitation_areaChild areaChild){
        return tb_areaChildMapper.updateTb_areaChild(areaChild);
    }

    //根据专区子版块ID更新专区子版块的点击数
    @RequestMapping("/updateClicknum/{id}")
    public int updateClicknum(@PathVariable("id") Integer id){
        return tb_areaChildMapper.updateClicknum(id);
    }

    //根据ID删除某个专区子版块
    @RequestMapping("/deleteTb_areaChild/{id}")
    public int deleteTb_areaChild(@PathVariable("id") Integer id){
        return tb_areaChildMapper.deleteTb_areaChild(id);
    }
}
