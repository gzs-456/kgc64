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
<<<<<<< HEAD
    public PageUtil getTb_friendPage(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer index=Integer.parseInt(map.get("index").toString());
        page.setPageIndex(index);
        //每页条数
        Integer size=Integer.parseInt(map.get("size").toString());
        page.setPageSize(size);
        //调用mapper方法
        List<Invitation_friend> list=tb_friendMapper.getTb_friendPage(map);
        int count=tb_friendMapper.getCount(map);
=======
    public PageUtil<Invitation_friend> getTb_friendPage(@RequestParam Integer userid,@RequestParam Integer pageIndex,@RequestParam Integer pageSize){
        PageUtil page=new PageUtil();
        //调用mapper方法
        List<Invitation_friend> list=tb_friendMapper.getTb_friendPage(userid,pageIndex,pageSize);
        int count=tb_friendMapper.getCount(userid);
>>>>>>> 28529312dbe521e62b9dc03d57690544878b2170
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
