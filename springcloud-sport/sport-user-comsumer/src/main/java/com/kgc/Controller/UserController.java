package com.kgc.Controller;

import com.kgc.pojo.User;
import com.kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
