package com.kgc.mapper;

import com.kgc.pojo.Column_channel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Column_channelMapper {
    //分页，查询所有的频道
    public List<Column_channel>getAllColumn_channel();
    public int getCount();

    //根据频道编号查询频道信息
    public Column_channel getChannelById(Integer id);

    //添加频道
    public int addChannel(Column_channel channel);

    //更新频道
    public int updateChannel(Column_channel channel);

    //根据频道编号删除频道
    public int deleteChannel(Integer id);
}
