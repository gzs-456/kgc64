package com.kgc.client.impl;

import com.kgc.client.Column_channelClient;
import com.kgc.pojo.Column_channel;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class Column_channelClientImpl implements Column_channelClient {
    @Override
    public PageUtil getAllColumn_channel(Map<String, Object> map) {
        return null;
    }

    @Override
    public Column_channel getChannelById(Integer id) {
        return null;
    }

    @Override
    public int addChannel(Column_channel channel) {
        return 0;
    }

    @Override
    public int updateChannel(Column_channel channel) {
        return 0;
    }

    @Override
    public int deleteChannel(Integer id) {
        return 0;
    }
}
