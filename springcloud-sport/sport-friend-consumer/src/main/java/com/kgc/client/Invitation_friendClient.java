package com.kgc.client;

import com.kgc.util.PageUtil;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@FeignClient(name="sport-friend-provider")
public interface Invitation_friendClient {
    //分页，根据用户编号查询所有好友
    @RequestMapping("/getAllInvitation_friend")
    public PageUtil getAllInvitation_friend(@RequestParam Map<String, Object> map);
    //根据用户编号和好友编号更新好友备注信息
    @RequestMapping("/updateBz")
    public int updateBz(@RequestParam(value="userid",required =false,defaultValue = "a1") String userid, @RequestParam(value="friendid",required =false,defaultValue = "b1") String friendid, @RequestParam(value="bz",required =false) String bz);
    //根据用户编号和好友编号更新是否相互关注
    @RequestMapping("/updateislike")
    public int updateislike(@RequestParam(value="userid",required =false,defaultValue = "a1") String userid, @RequestParam(value="friendid",required =false,defaultValue = "b1") String friendid, @RequestParam(value="islike",required =false) String islike);
    //根据用户编号和好友编号删除好友
    @RequestMapping("/deletefriend")
    public int deletefriend(@RequestParam(value="userid",required =false,defaultValue = "a1") String userid, @RequestParam(value="friendid",required =false,defaultValue = "b1") String friendid);
}
