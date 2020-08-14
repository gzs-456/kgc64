package com.kgc.controller;


import com.kgc.pojo.Invitation_friend;
import com.kgc.service.Invitation_friendService;
import com.kgc.util.PageUtil;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class Invitation_friendController {
    @Autowired
    private Invitation_friendService friendService;
    //分页，根据用户编号查询所有好友
    @RequestMapping("/getAllInvitation_friend")
    public PageUtil<Invitation_friend> getAllInvitation_friend(String userid,
            @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize){
        return friendService.getAllInvitation_friend(userid,pageIndex,pageSize);
    }
    //根据用户编号和好友编号更新好友备注信息
    @RequestMapping("/updateBz")
    public int updateBz(String userid, String friendid,  String bz){
        return friendService.updateBz(userid,friendid,bz);
    }
    //根据用户编号和好友编号更新是否相互关注
    @RequestMapping("/updateislike")
    public int updateislike(String userid, String friendid, String islike){
        return friendService.updateislike(userid,friendid,islike);
    }
    //根据用户编号和好友编号删除好友
    @RequestMapping("/delete")
    public int delete(String userid, String friendid){
        return friendService.delete(userid,friendid);
    }
}
