package com.kgc.service;

import com.kgc.mapper.Tb_chatrecordMapper;
import com.kgc.pojo.Invitation_chatrecord;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class RestChatecordService {
    @Autowired
    private Tb_chatrecordMapper tb_chatrecordMapper;

    @RequestMapping("/getChatecordPage")
    public PageUtil<Invitation_chatrecord> getTb_chatrecordPage(Integer putid,Integer gainid,Integer pageIndex,Integer pageSize){
        PageUtil page=new PageUtil();
        //调用mapper方法
        List<Invitation_chatrecord> list=tb_chatrecordMapper.getTb_chatrecordPage(putid,gainid,(pageIndex-1)*pageSize,pageSize);
        int count=tb_chatrecordMapper.getCount(putid,gainid);
        System.out.println(count);
        page.setList(list);
        page.setTotalCount(count);
        return page;
    }
    @RequestMapping("/addChatecord")
    public int addTb_chatrecord(@RequestBody Invitation_chatrecord chatrecord){
        return tb_chatrecordMapper.addTb_chatrecord(chatrecord);
    }



}
