package com.kgc.mapper;

import com.kgc.pojo.Column_comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Column_commentMapper {
    /*
        分页，根据评论人昵称，评论时间，评论级别，文章类型,0：普通 1：专栏进行查询
        并根据评论时间降序排列
        并根据评论人昵称分组
     */
    public List<Column_comment>getAllComment(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //根据文章编号，文章类型,0：普通 1：专栏来查询普通文章或是专栏文章的评论信息
    public List<Column_comment> getCommentById(Integer articleid,String atype);

    //根据文章类型0：普通 1：专栏，添加评论
    public int addComment(String atype,Column_comment comment);

    //根据文章类型0：普通 1：专栏，更新评论信息
    public int updateComment(String atype,Column_comment comment);

    //根据文章类型0：普通 1：专栏，和评论编号，删除评论信息
    public int deleteComment(String atype,Integer id);
}
