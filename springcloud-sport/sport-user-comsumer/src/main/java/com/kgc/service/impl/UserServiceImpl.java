package com.kgc.service.impl;

import com.kgc.client.UserFeign;
import com.kgc.pojo.User;
import com.kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    @Autowired
    UserFeign userFeign;

    @Override
    public User getUserlog(String loginname, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("loginname",loginname);
        map.put("password",password);
        return userFeign.getUserlog(map);
    }

    @Override
    public User getUserId(Integer id) {
        return userFeign.getUserId(id);
    }
}
