package com.kgc.mapper;

import com.kgc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    //登陆
    public User getUserlog(Map<String, Object> map);

    //查看个人信息
    public User getUserId(Integer id);

    //添加用户信息
    public int Useradd(User user);

    //修改
    public int UserUpdate(User user);

    //删除
    public  int Userdelect(Integer id);
}
