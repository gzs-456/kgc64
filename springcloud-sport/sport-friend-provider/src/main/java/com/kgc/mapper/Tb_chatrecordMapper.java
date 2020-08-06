package com.kgc.mapper;

import com.kgc.pojo.Invitation_chatrecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 聊天记录表provider接口
 */
@Mapper
public interface Tb_chatrecordMapper {
    //分页，根据聊天记录编号查询所有的聊天记录,按时间的顺序进行降序排列
    public List<Invitation_chatrecord> getTb_chatrecordPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //添加新的聊天记录
    public int addTb_chatrecord(Invitation_chatrecord chatrecord);

}
