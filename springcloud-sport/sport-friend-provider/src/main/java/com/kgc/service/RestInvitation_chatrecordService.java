package com.kgc.service;

import com.kgc.mapper.Invitation_chatrecordMapper;
import com.kgc.pojo.Invitation_chatrecord;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestInvitation_chatrecordService {
    @Autowired
    private Invitation_chatrecordMapper invitation_chatrecordMapper;

    //分页，根据发送方和接收方编号查询所有聊天信息,并按照发送时间降序排列
    @RequestMapping("/getAllInvitation_chatrecord")
    public PageUtil<Invitation_chatrecord> getAllInvitation_chatrecord(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = invitation_chatrecordMapper.getCount(map);
        page.setTotalCount(count);
        page.setList(invitation_chatrecordMapper.getAllInvitation_chatrecord(map));
        return page;
    }
    //添加聊天记录
    @RequestMapping("/addcontent")
    public int addcontent(@RequestBody Invitation_chatrecord invitation_chatrecord){
        return invitation_chatrecordMapper.addcontent(invitation_chatrecord);
    }
}
