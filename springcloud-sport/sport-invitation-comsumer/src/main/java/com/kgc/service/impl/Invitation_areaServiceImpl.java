package com.kgc.service.impl;

import com.kgc.client.Invitation_areaClient;
import com.kgc.pojo.Invitation_area;
import com.kgc.service.Invitation_areaService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Invitation_areaServiceImpl implements Invitation_areaService {
    @Autowired
    private Invitation_areaClient areaClient;
    //分页,根据专区名称查询所有
    @Override
    public PageUtil<Invitation_area> getTb_areaPage(String areaname, Integer pageIndex, Integer pageSize) {
        //封装成一个map对象
        Map<String,Object> map=new HashMap<>();
        map.put("areaname",areaname);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        return areaClient.getTb_areaPage(map);
    }
    //帖子表，专区表两表连接查询,根据帖子编号查询所有专区
    @Override
    public List<Invitation_area> getByinvitationId(Integer invitationId) {
        return areaClient.getByinvitationId(invitationId);
    }
    //根据专区编号查询某一个专区介绍信息
    @Override
    public Invitation_area getTb_areaById(Integer id) {
        return areaClient.getTb_areaById(id);
    }
    //添加新的专区
    @Override
    public int addTb_area(Invitation_area area) {
        return areaClient.addTb_area(area);
    }
    //更新专区信息
    @Override
    public int updateTb_area(Invitation_area area) {
        return areaClient.updateTb_area(area);
    }
    //根据专区ID更新专区的点击数
    @Override
    public int updateClicknum(Integer id) {
        return areaClient.updateClicknum(id);
    }
    //根据ID删除某个专区
    @Override
    public int deleteTb_area(Integer id) {
        return areaClient.deleteTb_area(id);
    }
}
