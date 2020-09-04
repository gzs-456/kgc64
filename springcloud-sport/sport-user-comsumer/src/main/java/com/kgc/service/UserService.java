package com.kgc.service;

import com.kgc.pojo.User;

public interface UserService {
    public User getUserlog(String nickname,String password);

    public User getUserId(Integer id);

    //添加用户信息
    public int Useradd(User user);

    //修改
    public int UserUpdate(User user);

    //删除
    public  int Userdelect(Integer id);
}
