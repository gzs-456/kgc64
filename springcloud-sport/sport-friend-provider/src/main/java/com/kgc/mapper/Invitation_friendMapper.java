package com.kgc.mapper;

import com.kgc.pojo.Invitation_friend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface Invitation_friendMapper {
    //分页，根据用户编号查询所有好友
    public List<Invitation_friend>getAllInvitation_friend(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //根据用户编号和好友编号更新好友备注信息
    public int updateBz(@Param("userid")Integer userid,@Param("friendid") Integer friendid,@Param("bz") String bz);

    //根据用户编号和好友编号更新是否相互关注
    public int updateislike(@Param("userid")Integer userid,@Param("friendid") Integer friendid,@Param("islike") String islike);

    //根据用户编号和好友编号删除好友
    public int delete(@Param("userid")Integer userid,@Param("friendid") Integer friendid);
}
