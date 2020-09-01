package com.kgc.service.impl;

import com.kgc.client.Invitation_areaChildClient;
import com.kgc.config.InvitationUtil;
import com.kgc.pojo.Invitation_areaChild;
import com.kgc.service.Invitation_areaChildService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Invitation_areaChildServiceImpl implements Invitation_areaChildService {
    @Autowired
    private Invitation_areaChildClient areaChildClient;
    @Autowired
    private InvitationUtil invitationUtil;

    //分页,根据专区子版块名称查询所有
    @Override
    public PageUtil<Invitation_areaChild> getTb_areaChildPage(String areaname, Integer pageIndex, Integer pageSize) {
        //封装成一个map对象
        Map<String,Object>map=new HashMap<>();
        map.put("areaname",areaname);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        try {
            invitationUtil.searchpage(pageIndex,pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return areaChildClient.getTb_areaChildPage(map);
    }
    //帖子表，专区子版块表两表连接查询,根据帖子编号查询所有专区子版块
    @Override
    public List<Invitation_areaChild> getByinvitationId(Integer invitationId) {
        return areaChildClient.getByinvitationId(invitationId);
    }
    //专区表，专区子版块表两表连接查询,根据专区编号查询所有专区子版块
    @Override
    public List<Invitation_areaChild> getByareaId(Integer areaId) {
        return areaChildClient.getByareaId(areaId);
    }
    //根据专区子版块编号查询某一个专区子版块介绍信息
    @Override
    public Invitation_areaChild getTb_areaById(Integer id) {
        return areaChildClient.getTb_areaById(id);
    }
    //添加新的专区子版块
    @Override
    public int addTb_areaChild(Invitation_areaChild areaChild) {
        return areaChildClient.addTb_areaChild(areaChild);
    }
    //更新专区子版块信息
    @Override
    public int updateTb_areaChild(Invitation_areaChild areaChild) {
        return areaChildClient.updateTb_areaChild(areaChild);
    }
    //根据专区子版块ID更新专区子版块的点击数
    @Override
    public int updateClicknum(Integer id) {
        return areaChildClient.updateClicknum(id);
    }
    //根据ID删除某个专区子版块
    @Override
    public int deleteTb_areaChild(Integer id) {
        return areaChildClient.deleteTb_areaChild(id);
    }
}
