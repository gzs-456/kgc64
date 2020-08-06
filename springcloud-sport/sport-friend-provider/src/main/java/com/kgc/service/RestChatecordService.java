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
    public PageUtil<Invitation_chatrecord> getTb_chatrecordPage(@RequestParam Map<String, Object> param){
        PageUtil page=new PageUtil();
        //当前页面
        Integer index=Integer.parseInt(param.get("index").toString());
        System.out.println(index);
        page.setPageIndex(index);
        //每页条数
        Integer size=Integer.parseInt(param.get("size").toString());
        page.setPageSize(size);
        //调用mapper方法
        List<Invitation_chatrecord> list=tb_chatrecordMapper.getTb_chatrecordPage(param);
        int count=tb_chatrecordMapper.getCount(param);
        page.setList(list);
        page.setTotalCount(count);
        return page;
    }
    @RequestMapping("/addChatecord")
    public int addTb_chatrecord(@RequestBody Invitation_chatrecord chatrecord){
        return tb_chatrecordMapper.addTb_chatrecord(chatrecord);
    }



}
