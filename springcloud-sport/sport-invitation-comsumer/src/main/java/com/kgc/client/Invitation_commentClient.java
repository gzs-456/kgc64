package com.kgc.client;


import com.kgc.pojo.Invitation_comment;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="sport-invitation-provider")
public interface Invitation_commentClient {
    //分页，帖子表，评论表两表连接查询,根据帖子编号查询所有评论
    @RequestMapping("/getTb_commentPage")
    public PageUtil getTb_commentPage(@RequestParam Map<String,Object> map);
    //添加新的帖子评论
    @RequestMapping("/addTb_comment")
    public int addTb_comment(@RequestBody Invitation_comment comment);
    //更新帖子评论信息
    @RequestMapping("/updateTb_comment")
    public int updateTb_comment(@RequestBody Invitation_comment comment);
    //根据帖子ID更新帖子评论的点赞数
    @RequestMapping("/updateCnum/{id}")
    public int updateCnum(@PathVariable("id") Integer id);
    //根据ID删除某个帖子评论
    @RequestMapping("/deleteTb_comment/{id}")
    public int deleteTb_comment(@PathVariable("id") Integer id);
}
