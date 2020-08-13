package com.kgc.service;

import com.kgc.mapper.Tb_friendMapper;
import com.kgc.pojo.Invitation_friend;
import com.kgc.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestFriendService {
    @Autowired
    private Tb_friendMapper tb_friendMapper;

    @RequestMapping("/getFriendPage")
    public PageUtil<Invitation_friend> getTb_friendPage(@RequestParam Integer userid,@RequestParam Integer pageIndex,@RequestParam Integer pageSize){
        PageUtil page=new PageUtil();
        //调用mapper方法
        List<Invitation_friend> list=tb_friendMapper.getTb_friendPage(userid,pageIndex,pageSize);
        int count=tb_friendMapper.getCount(userid);
        page.setList(list);
        page.setTotalCount(count);
        return page;
    }

    @RequestMapping("/addFriend")
    public int addTb_friend(@RequestBody Invitation_friend friend){
        return tb_friendMapper.addTb_friend(friend);
    }

    @RequestMapping("/updateFriend")
    public int updateTb_friend(@RequestBody Invitation_friend friend){
        return tb_friendMapper.updateTb_friend(friend);
    }

    @RequestMapping("/del")
    public int deleteTb_friend(@Param("friendid") String friendid){
        return tb_friendMapper.deleteTb_friend(friendid);
    }
}
