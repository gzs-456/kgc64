package com.kgc.service;

import com.kgc.pojo.Column_comment;
import com.kgc.util.PageUtil;

import java.util.List;

public interface Column_commentService {
    /*
        分页，根据评论人昵称，评论时间，评论级别，文章类型,0：普通 1：专栏进行查询
        并根据评论时间降序排列
        并根据评论人昵称分组
     */
    public PageUtil<Column_comment> getAllComment(String nickname, String publishdate, Integer parentid, String atype, Integer pageIndex, Integer pageSize);

    //根据文章编号，文章类型,0：普通 1：专栏来查询普通文章或是专栏文章的评论信息
    public List<Column_comment> getCommentById(Integer articleid, String atype);

    //添加评论
    public int addComment(Column_comment comment);

    //更新评论信息
    public int updateComment(Column_comment comment);

    //根据评论编号，删除评论信息
    public int deleteComment(Integer id);
}
