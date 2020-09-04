package com.kgc.client;

import com.kgc.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="sport-user-provider")
public interface UserFeign {
    @RequestMapping("/Userlog")
    public User getUserlog(@RequestParam Map<String, Object> param);

    @RequestMapping("/getUserId/{id}")
    public User getUserId(@PathVariable("id") Integer id);


    @RequestMapping("/Useradd")
    public int Useradd(@RequestBody User user);

    @RequestMapping("/UserUpdate")
    public int UserUpdate(@RequestBody User user);

    @RequestMapping("/Userdelect/{id}")
    public  int Userdelect(@PathVariable("id") Integer id);

}
