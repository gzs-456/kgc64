package com.kgc.mapper;

import com.kgc.pojo.User;
import com.kgc.pojo.User_Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


@Mapper
public interface AdminMapper {
    //登陆
    public User_Admin getlog(Map<String, Object> map);

    //查看个人信息
    public User_Admin getAdminId(Integer id);

    //添加用户信息
    public int add(User_Admin user_admin);

    //修改
    public int Update(User_Admin user_admin);

    //删除
    public  int delect(Integer id);

}
