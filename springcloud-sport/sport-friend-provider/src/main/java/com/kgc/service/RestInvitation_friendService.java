package com.kgc.service;


import com.kgc.mapper.Invitation_friendMapper;
import com.kgc.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestInvitation_friendService {
    @Autowired
    private Invitation_friendMapper friendMapper;

    //分页，根据用户编号查询所有好友
    @RequestMapping("/getAllInvitation_friend")
    public PageUtil getAllInvitation_friend(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = friendMapper.getCount(map);
        page.setTotalCount(count);
        page.setList(friendMapper.getAllInvitation_friend(map));
        return page;
    }
    //根据用户编号和好友编号更新好友备注信息
    @RequestMapping("/updateBz")
    public int updateBz(@RequestParam(value="userid",required =false,defaultValue = "a1") String userid, @RequestParam(value="friendid",required =false,defaultValue = "b1") String friendid, @RequestParam(value="bz",required =false) String bz){
        return friendMapper.updateBz(userid,friendid,bz);
    }

    //根据用户编号和好友编号更新是否相互关注
    @RequestMapping("/updateislike")
    public int updateislike(@RequestParam(value="userid",required =false,defaultValue = "a1") String userid, @RequestParam(value="friendid",required =false,defaultValue = "b1") String friendid, @RequestParam(value="islike",required =false) String islike){
        return friendMapper.updateislike(userid,friendid,islike);
    }

    //根据用户编号和好友编号删除好友
    @RequestMapping("/deletefriend")
    public int deletefriend(@RequestParam(value="userid",required =false,defaultValue = "a1") String userid, @RequestParam(value="friendid",required =false,defaultValue = "b1") String friendid){
        return friendMapper.delete(userid,friendid);
    }
}
