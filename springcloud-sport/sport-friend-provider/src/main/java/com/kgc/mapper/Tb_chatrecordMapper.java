package com.kgc.mapper;

import com.kgc.pojo.Invitation_chatrecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 聊天记录表provider接口
 */
@Mapper
public interface Tb_chatrecordMapper {
    //分页，根据聊天记录编号查询所有的聊天记录,按时间的顺序进行降序排列
    public List<Invitation_chatrecord> getTb_chatrecordPage(@Param("putid") Integer putid,@Param("gainid") Integer gainid,
                                                            @Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
    public int getCount(@Param("putid") Integer putid,@Param("gainid") Integer gainid);

    //添加新的聊天记录
    public int addTb_chatrecord(Invitation_chatrecord chatrecord);
 
}
