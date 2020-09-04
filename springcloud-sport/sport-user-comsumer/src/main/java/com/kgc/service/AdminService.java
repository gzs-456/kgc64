package com.kgc.service;

import com.kgc.pojo.User_Admin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface AdminService {

    public User_Admin getlog(String loginname,String password);

    public User_Admin getAdminId(Integer id);

    //添加用户信息
    public int add(User_Admin user_admin);

    //修改
    public int Update(User_Admin user_admin);

    //删除
    public  int delect(Integer id);


}
