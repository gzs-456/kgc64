package com.kgc.service;

import com.kgc.mapper.Column_channelMapper;

import com.kgc.pojo.Column_channel;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Column_channelService {
    @Autowired
    private Column_channelMapper channelMapper;

    //分页，查询所有的频道
    @RequestMapping("/getAllColumn_channel")
    public PageUtil getAllColumn_channel(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = channelMapper.getCount(map);
        page.setTotalCount(count);
        //调用mapper方法
        List<Column_channel> list = channelMapper.getAllColumn_channel(map);
        page.setList(list);
        return page;
    }

    //根据频道编号查询频道信息
    @RequestMapping("/getAllColumn_channel/{id}")
    public Column_channel getChannelById(@PathVariable("id") Integer id){
        return channelMapper.getChannelById(id);
    }

    //添加频道
    @RequestMapping("/addChannel")
    public int addChannel(@RequestBody Column_channel channel){
        return channelMapper.addChannel(channel);
    }

    //更新频道
    @RequestMapping("/updateChannel")
    public int updateChannel(@RequestBody Column_channel channel){
        return channelMapper.updateChannel(channel);
    }

    //根据频道编号删除频道
    @RequestMapping("/deleteChannel/{id}")
    public int deleteChannel(@PathVariable("id")Integer id){
        return channelMapper.deleteChannel(id);
    }
}
