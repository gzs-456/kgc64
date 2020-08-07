package com.kgc.service.impl;

import com.kgc.client.AdminFeign;
import com.kgc.pojo.User_Admin;
import com.kgc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminFeign adminFeign;

    @Override
    public User_Admin getlog(String loginname,String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("loginname",loginname);
        map.put("password",password);
        return adminFeign.getlog(map);
    }

    @Override
    public User_Admin getAdminId(Integer id) {
        return adminFeign.getAdminId(id);
    }
}
