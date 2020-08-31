package com.kgc.service.impl;

import com.kgc.client.Column_channelClient;
import com.kgc.pojo.Column_channel;
import com.kgc.service.Column_channelService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Column_channelServiceImpl implements Column_channelService {
    @Autowired
    private Column_channelClient channelClient;
    //分页，查询所有的频道
    @Override
    public PageUtil<Column_channel> getAllColumn_channel(Integer pageIndex, Integer pageSize) {
        Map<String,Object> map=new HashMap<>();
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        return channelClient.getAllColumn_channel(map);
    }
    //根据频道编号查询频道信息
    @Override
    public Column_channel getChannelById(Integer id) {
        return channelClient.getChannelById(id);
    }
    //添加频道
    @Override
    public int addChannel(Column_channel channel) {
        return channelClient.addChannel(channel);
    }
    //更新频道
    @Override
    public int updateChannel(Column_channel channel) {
        return channelClient.updateChannel(channel);
    }
    //根据频道编号删除频道
    @Override
    public int deleteChannel(Integer id) {
        return channelClient.deleteChannel(id);
    }
}
