package com.kgc.client;

import com.kgc.pojo.User_Admin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="sport-user-provider")
public interface AdminFeign {

    @RequestMapping("/log")
    public User_Admin getlog(@RequestParam Map<String, Object> param);

    @RequestMapping("/getAdminId/{id}")
    public User_Admin getAdminId(@PathVariable("id") Integer id);


    @RequestMapping("/add")
    public int add(@RequestBody User_Admin user_admin);

    @RequestMapping("/Update")
    public int Update(@RequestBody User_Admin user_admin);

    @RequestMapping("/delect/{id}")
    public  int delect(@PathVariable("id") Integer id);
}
