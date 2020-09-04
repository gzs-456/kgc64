package com.kgc.Controller;

import com.kgc.pojo.User_Admin;
import com.kgc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/log")
    public User_Admin getlog(String loginname,String password) {
        return adminService.getlog(loginname,password);
    }

    @RequestMapping("/getAdminId")
    public User_Admin getAdminId(Integer id) {
        return adminService.getAdminId(id);
    }


    @RequestMapping("/add")
    public int add(@RequestBody User_Admin user_admin){
        return adminService.add(user_admin);
    }

    @RequestMapping("/Update")
    public int Update(@RequestBody User_Admin user_admin){
        return adminService.Update(user_admin);
    }

    @RequestMapping("/delect/{id}")
    public  int delect(@PathVariable("id") Integer id){
        return adminService.delect(id);
    }
}
