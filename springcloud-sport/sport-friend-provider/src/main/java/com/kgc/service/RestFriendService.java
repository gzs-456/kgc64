package com.kgc.service;

import com.kgc.mapper.Tb_friendMapper;
import com.kgc.pojo.Invitation_friend;
import com.kgc.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestFriendService {
    @Autowired
    private Tb_friendMapper tb_friendMapper;

    @RequestMapping("/getFriendPage")
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
