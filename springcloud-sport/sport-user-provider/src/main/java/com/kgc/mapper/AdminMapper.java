package com.kgc.mapper;

import com.kgc.pojo.User_Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


@Mapper
public interface AdminMapper {
    //登陆
    public User_Admin getlog(Map<String, Object> map);

    //查看个人信息
    public User_Admin getAdminId(Integer id);

}
