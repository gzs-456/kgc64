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
}
