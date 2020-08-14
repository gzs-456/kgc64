package com.kgc.service;


import com.kgc.pojo.Invitation_friend;
import com.kgc.util.PageUtil;


public interface Invitation_friendService {
    //分页，根据用户编号查询所有好友
    public PageUtil<Invitation_friend> getAllInvitation_friend(String userid,Integer pageIndex, Integer pageSize);

    //根据用户编号和好友编号更新好友备注信息
    public int updateBz(String userid,  String friendid, String bz);

    //根据用户编号和好友编号更新是否相互关注
    public int updateislike(String userid,  String friendid,  String islike);

    //根据用户编号和好友编号删除好友
    public int delete(String userid,  String friendid);
}
