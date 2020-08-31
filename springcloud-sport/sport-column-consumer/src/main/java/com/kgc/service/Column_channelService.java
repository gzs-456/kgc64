package com.kgc.service;


import com.kgc.pojo.Column_channel;
import com.kgc.util.PageUtil;

public interface Column_channelService {
    //分页，查询所有的频道
    public PageUtil<Column_channel> getAllColumn_channel(Integer pageIndex, Integer pageSize);

    //根据频道编号查询频道信息
    public Column_channel getChannelById(Integer id);

    //添加频道
    public int addChannel(Column_channel channel);

    //更新频道
    public int updateChannel(Column_channel channel);

    //根据频道编号删除频道
    public int deleteChannel(Integer id);
}
