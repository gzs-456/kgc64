package com.kgc.Controller;

import com.kgc.pojo.User_Admin;
import com.kgc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
