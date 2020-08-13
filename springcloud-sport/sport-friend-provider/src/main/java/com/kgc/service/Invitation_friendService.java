package com.kgc.service;


import com.kgc.mapper.Invitation_friendMapper;
import com.kgc.pojo.Invitation_friend;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Invitation_friendService {
    @Autowired
    private Invitation_friendMapper invitation_friendMapper;

    @RequestMapping("/pageFriend")
    public PageUtil<Invitation_friend> getAllInvitation_friend(Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        //Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(1);
        //每页条数
        //Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(2);
        int count = invitation_friendMapper.getCount(map);
        page.setTotalCount(count);
        page.setList(invitation_friendMapper.getAllInvitation_friend(map));
        return page;
    }
}
