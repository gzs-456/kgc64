package com.kgc.controller;

import com.kgc.pojo.Column_channel;
import com.kgc.service.Column_channelService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class Column_channelController {
    @Autowired
    private Column_channelService channelService;

    //分页，查询所有的频道
    @RequestMapping("/getAllColumn_channel")
    public PageUtil getAllColumn_channel(@RequestParam(value = "pageIndex", defaultValue = "1")Integer pageIndex,
                                         @RequestParam(value = "pageSize", defaultValue = "2")Integer pageSize){
        return channelService.getAllColumn_channel(pageIndex,pageSize);
    }

    //根据频道编号查询频道信息
    @RequestMapping("/getChannelById")
    public Column_channel getChannelById( Integer id){
        return channelService.getChannelById(id);
    }

    //添加频道
    @RequestMapping("/addChannel")
    public int addChannel( Column_channel channel){
        return channelService.addChannel(channel);
    }

    //更新频道
    @RequestMapping("/updateChannel")
    public int updateChannel( Column_channel channel){
        return channelService.updateChannel(channel);
    }

    //根据频道编号删除频道
    @RequestMapping("/deleteChannel")
    public int deleteChannel(Integer id){
        return channelService.deleteChannel(id);
    }
}
