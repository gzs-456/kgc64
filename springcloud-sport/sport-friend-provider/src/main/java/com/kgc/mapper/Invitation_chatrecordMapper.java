package com.kgc.mapper;

import com.kgc.pojo.Invitation_chatrecord;

import java.util.List;
import java.util.Map;

public interface Invitation_chatrecordMapper {
    //分页，根据发送方和接收方编号查询所有聊天信息,并按照发送时间降序排列
    public List<Invitation_chatrecord>getAll(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //根据聊天记录编号，更新聊天内容为空
    public int updatecontent(Integer id);
}
