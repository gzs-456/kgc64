package com.kgc.service;

import com.kgc.mapper.Invitation_chatrecordMapper;
import com.kgc.pojo.Invitation_chatrecord;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Invitation_chatrecordService {
    @Autowired
    private Invitation_chatrecordMapper invitation_chatrecordMapper;

    @RequestMapping("/pagechatrecord")
    public PageUtil<Invitation_chatrecord> getAll(Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = invitation_chatrecordMapper.getCount(map);
        page.setTotalCount(count);
        page.setList(invitation_chatrecordMapper.getAll(map));
        return page;
    }
}
