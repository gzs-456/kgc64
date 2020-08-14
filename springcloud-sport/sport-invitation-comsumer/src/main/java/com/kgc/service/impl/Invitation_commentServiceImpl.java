package com.kgc.service.impl;

import com.kgc.client.Invitation_commentClient;
import com.kgc.pojo.Invitation_comment;
import com.kgc.service.Invitation_commentService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Invitation_commentServiceImpl implements Invitation_commentService {
    @Autowired
    private Invitation_commentClient commentClient;
    //分页，帖子表，评论表两表连接查询,根据帖子编号查询所有评论
    @Override
    public PageUtil<Invitation_comment> getTb_commentPage(Integer invitationId, Integer pageIndex, Integer pageSize) {
        //封装成一个map对象
        Map<String,Object>map=new HashMap<>();
        map.put("invitationId",invitationId);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        return commentClient.getTb_commentPage(map);
    }
    //添加新的帖子评论
    @Override
    public int addTb_comment(Invitation_comment comment) {
        return commentClient.addTb_comment(comment);
    }
    //更新帖子评论信息
    @Override
    public int updateTb_comment(Invitation_comment comment) {
        return commentClient.updateTb_comment(comment);
    }
    //根据帖子ID更新帖子评论的点赞数
    @Override
    public int updateCnum(Integer id) {
        return commentClient.updateCnum(id);
    }
    //根据ID删除某个帖子评论
    @Override
    public int deleteTb_comment(Integer id) {
        return commentClient.deleteTb_comment(id);
    }
}
