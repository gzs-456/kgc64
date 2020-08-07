package com.kgc.service;

import com.kgc.mapper.UserMapper;
import com.kgc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestUserService {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/Userlog")
    public User getUserlog(@RequestParam Map<String, Object> param){
        Map<String,Object> map = new HashMap<>();
        String nickname = param.get("nickname").toString();
        String password = param.get("password").toString();
        map.put("nickname",nickname);
        map.put("password",password);

        return userMapper.getUserlog(map);
    }

    @RequestMapping("/getUserId/{id}")
    public User getUserId(@PathVariable("id") Integer id){
        return userMapper.getUserId(id);
    }
}
