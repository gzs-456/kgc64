package com.kgc.client;


import com.kgc.pojo.User_Admin;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AdminFeignImpl implements AdminFeign {

    @Override
    public User_Admin getlog(Map<String, Object> param) {
        return null;
    }

    @Override
    public User_Admin getAdminId(Integer id) {
        return null;
    }

    @Override
    public int add(User_Admin user_admin) {
        return 0;
    }

    @Override
    public int Update(User_Admin user_admin) {
        return 0;
    }

    @Override
    public int delect(Integer id) {
        return 0;
    }
}
