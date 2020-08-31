package com.kgc.client;

import com.kgc.client.impl.Column_channelClientImpl;
import com.kgc.pojo.Column_channel;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="sport-column-provider",fallback = Column_channelClientImpl.class)
public interface Column_channelClient {
    //分页，查询所有的频道
    @RequestMapping("/getAllColumn_channel")
    public PageUtil getAllColumn_channel(@RequestParam Map<String, Object> map);

    //根据频道编号查询频道信息
    @RequestMapping("/getChannelById/{id}")
    public Column_channel getChannelById(@PathVariable("id") Integer id);

    //添加频道
    @RequestMapping("/addChannel")
    public int addChannel(@RequestBody Column_channel channel);

    //更新频道
    @RequestMapping("/updateChannel")
    public int updateChannel(@RequestBody Column_channel channel);

    //根据频道编号删除频道
    @RequestMapping("/deleteChannel/{id}")
    public int deleteChannel(@PathVariable("id") Integer id);

}
