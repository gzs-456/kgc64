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
}
