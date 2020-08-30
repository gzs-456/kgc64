package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kgc.mapper.AdminMapper;
import com.kgc.pojo.User_Admin;
import com.kgc.util.MD5;
import com.kgc.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class RestAdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtils redisUtils;

    @RequestMapping("/log")
    public User_Admin getlog(@RequestParam Map<String, Object> param){
        //存入redis
        Map<String,Object> map = new HashMap<>();
        String loginname = param.get("loginname").toString();
        String password = param.get("password").toString();
        map.put("loginname",loginname);
        map.put("password",password);
        User_Admin user_admin=adminMapper.getlog(map);
        String token="token";
        token+= MD5.getMd5(user_admin.getLoginname(),8)+"-";
        token+=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if(user_admin!=null){
            redisTemplate.opsForValue().set(token,JSON.toJSONString(user_admin),2*60*60, TimeUnit.SECONDS);
        }
        return adminMapper.getlog(map);
    }

    //从redis获取用户
    @RequestMapping("/getUser_admin")
    public User_Admin getUserAdminFromRedis(@RequestBody String token){
        if(redisUtils.exist(token)){
            String jsonStr=redisTemplate.opsForValue().get(token).toString();
            User_Admin user_admin= JSONObject.parseObject(jsonStr,User_Admin.class);
            if(user_admin!=null){
                return user_admin;
            }
        }
        return null;
    }


    @RequestMapping("/getAdminId/{id}")
    public User_Admin getAdminId(@PathVariable("id") Integer id){
        return adminMapper.getAdminId(id);
    }
}
