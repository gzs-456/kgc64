package com.kgc.service;

import com.kgc.pojo.Invitation_comment;
import com.kgc.util.PageUtil;


public interface Invitation_commentService {
    //分页，帖子表，评论表两表连接查询,根据帖子编号查询所有评论
    public PageUtil<Invitation_comment> getTb_commentPage(Integer invitationId,Integer pageIndex,Integer pageSize);

    //添加新的帖子评论
    public int addTb_comment(Invitation_comment comment);

    //更新帖子评论信息
    public int updateTb_comment(Invitation_comment comment);

    //根据帖子ID更新帖子评论的点赞数
    public int updateCnum(Integer id);

    //根据ID删除某个帖子评论
    public int deleteTb_comment(Integer id);
}
