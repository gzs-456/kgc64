package com.kgc.service;

import com.kgc.mapper.AdminMapper;
import com.kgc.pojo.User_Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestAdminService {

    @Autowired
    AdminMapper adminMapper;

    @RequestMapping("/log")
    public User_Admin getlog(@RequestParam Map<String, Object> param){
        Map<String,Object> map = new HashMap<>();
        String loginname = param.get("loginname").toString();
        String password = param.get("password").toString();
        map.put("loginname",loginname);
        map.put("password",password);

        return adminMapper.getlog(map);
    }


    @RequestMapping("/getAdminId/{id}")
    public User_Admin getAdminId(@PathVariable("id") Integer id){
        return adminMapper.getAdminId(id);
    }
}
