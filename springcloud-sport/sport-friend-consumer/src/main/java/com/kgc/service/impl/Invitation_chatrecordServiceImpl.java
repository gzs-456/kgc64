package com.kgc.service.impl;

import com.kgc.client.Invitation_chatrecordClient;
import com.kgc.pojo.Invitation_chatrecord;
import com.kgc.service.Invitation_chatrecordService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Invitation_chatrecordServiceImpl implements Invitation_chatrecordService {

    @Autowired
    private Invitation_chatrecordClient chatrecordClient;
    //分页，根据发送方和接收方编号查询所有聊天信息,并按照发送时间降序排列
    @Override
    public PageUtil<Invitation_chatrecord> getAllInvitation_chatrecord(String putid, String gainid, Integer pageIndex, Integer pageSize) {
        //封装成一个map对象
        Map<String,Object> map=new HashMap<>();
        map.put("putid",putid);
        map.put("gainid",gainid);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        return chatrecordClient.getAllInvitation_chatrecord(map);
    }
    //添加聊天记录
    @Override
    public int addcontent(Invitation_chatrecord invitation_chatrecord) {
        return chatrecordClient.addcontent(invitation_chatrecord);
    }
}
