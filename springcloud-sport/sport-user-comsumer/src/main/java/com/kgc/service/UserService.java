package com.kgc.service;

import com.kgc.pojo.User;

public interface UserService {
    public User getUserlog(String nickname,String password);

    public User getUserId(Integer id);
}
