package com.kgc.client;

import com.kgc.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserFeignImpl implements UserFeign {

    @Override
    public User getUserlog(Map<String, Object> param) {
        return null;
    }

    @Override
    public User getUserId(Integer id) {
        return null;
    }

    @Override
    public int Useradd(User user) {
        return 0;
    }

    @Override
    public int UserUpdate(User user) {
        return 0;
    }

    @Override
    public int Userdelect(Integer id) {
        return 0;
    }
}
