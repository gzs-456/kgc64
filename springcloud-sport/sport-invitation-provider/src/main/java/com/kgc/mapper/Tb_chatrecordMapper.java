package com.kgc.mapper;

import com.kgc.pojo.Tb_chatrecord;

import java.util.List;
import java.util.Map;

/**
 * 聊天记录表provider接口
 */
public interface Tb_chatrecordMapper {
    //分页，根据聊天记录编号查询所有的聊天记录,按时间的顺序进行降序排列
    public List<Tb_chatrecord> getTb_chatrecordPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //添加新的聊天记录
    public int addTb_chatrecord(Tb_chatrecord chatrecord);

}