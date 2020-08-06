package com.kgc.mapper;


import com.kgc.pojo.Invitation_friend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 好友表provider接口
 */
@Mapper
public interface Tb_friendMapper {
    //分页，根据用户编号查询所有的好友
    public List<Invitation_friend> getTb_friendPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //根据好友编号查询好友信息
    public Invitation_friend getTb_friendById(String userid);

    //添加新的好友
    public int addTb_friend(Invitation_friend friend);

    //更新好友备注信息
    public int updateTb_friend(Invitation_friend friend);

    //根据好友ID删除某个好友
    public int deleteTb_friend(String friendid);
}
