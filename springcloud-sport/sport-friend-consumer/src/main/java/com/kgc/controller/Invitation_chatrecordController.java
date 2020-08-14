package com.kgc.controller;

import com.kgc.pojo.Invitation_chatrecord;
import com.kgc.service.Invitation_chatrecordService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class Invitation_chatrecordController {
    @Autowired
    private Invitation_chatrecordService chatrecordService;
    //分页，根据发送方和接收方编号查询所有聊天信息,并按照发送时间降序排列
    @RequestMapping("/getAllInvitation_chatrecord")
        public PageUtil<Invitation_chatrecord> getAllInvitation_chatrecord(String putid,String gainid,
        @RequestParam(value = "pageIndex",required =false, defaultValue = "1") Integer pageIndex,
        @RequestParam(value = "pageSize",required =false, defaultValue = "2") Integer pageSize){
        return chatrecordService.getAllInvitation_chatrecord(putid,gainid,pageIndex,pageSize);
    }
    //添加聊天记录
    @RequestMapping("/addcontent")
    public int addcontent(@RequestBody Invitation_chatrecord invitation_chatrecord){
        return chatrecordService.addcontent(invitation_chatrecord);
    }
}
