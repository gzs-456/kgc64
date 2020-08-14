package com.kgc.service.impl;

import com.kgc.client.Invitation_friendClient;
import com.kgc.pojo.Invitation_friend;
import com.kgc.service.Invitation_friendService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Invitation_friendServiceImpl implements Invitation_friendService {
    @Autowired
    private Invitation_friendClient friendClient;
    //分页，根据用户编号查询所有好友
    @Override
    public PageUtil<Invitation_friend> getAllInvitation_friend(String userid, Integer pageIndex, Integer pageSize) {
        //封装成一个map对象
        Map<String,Object> map=new HashMap<>();
        map.put("userid",userid);
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        return friendClient.getAllInvitation_friend(map);
    }
    //根据用户编号和好友编号更新好友备注信息
    @Override
    public int updateBz(String userid, String friendid, String bz) {
        return friendClient.updateBz(userid,friendid,bz);
    }
    //根据用户编号和好友编号更新是否相互关注
    @Override
    public int updateislike(String userid, String friendid, String islike) {
        return friendClient.updateislike(userid,friendid,islike);
    }
    //根据用户编号和好友编号删除好友
    @Override
    public int delete(String userid, String friendid) {
        return friendClient.deletefriend(userid,friendid);
    }
}
