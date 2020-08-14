package com.kgc.service;


import com.kgc.pojo.Invitation_chatrecord;
import com.kgc.util.PageUtil;



public interface Invitation_chatrecordService {
    //分页，根据发送方和接收方编号查询所有聊天信息,并按照发送时间降序排列
    public PageUtil<Invitation_chatrecord> getAllInvitation_chatrecord(String putid,String gainid, Integer pageIndex, Integer pageSize);

    //添加聊天记录
    public int addcontent(Invitation_chatrecord invitation_chatrecord);
}
