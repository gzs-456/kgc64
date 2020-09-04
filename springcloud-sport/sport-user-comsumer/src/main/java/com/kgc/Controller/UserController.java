package com.kgc.Controller;

import com.kgc.pojo.User;
import com.kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/Userlog")
    public User getUserlog(String nickname,String password) {
        return userService.getUserlog(nickname,password);
    }

    @RequestMapping("/getUserId")
    public User getUserId(Integer id) {
        return userService.getUserId(id);
    }

    @RequestMapping("/Useradd")
    public int Useradd(@RequestBody User user){
        return userService.Useradd(user);
    }

    @RequestMapping("/UserUpdate")
    public int UserUpdate(@RequestBody User user){
        return userService.UserUpdate(user);
    }

    @RequestMapping("/Userdelect/{id}")
    public  int Userdelect(@PathVariable("id") Integer id){
        return userService.Userdelect(id);
    }
}
