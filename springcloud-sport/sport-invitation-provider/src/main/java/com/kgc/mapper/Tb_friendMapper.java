package com.kgc.mapper;


import com.kgc.pojo.Tb_friend;

import java.util.List;
import java.util.Map;

/**
 * 好友表provider接口
 */
public interface Tb_friendMapper {
    //分页，根据好友编号查询所有的好友
    public List<Tb_friend> getTb_friendPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //根据好友编号查询好友信息
    public Tb_friend getTb_friendById(String userid);

    //添加新的好友
    public int addTb_friend(Tb_friend friend);

    //更新好友备注信息
    public int updateTb_friend(Tb_friend friend);

    //根据好友ID删除某个好友
    public int deleteTb_friend(String userid);
}
