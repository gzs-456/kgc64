package com.kgc.mapper;


import com.kgc.pojo.Invitation_comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 帖子评论表provider接口
 */
@Mapper
public interface Tb_commentMapper {
    //分页，帖子表，评论表两表连接查询,根据帖子编号查询所有评论
    public List<Invitation_comment>getTb_commentPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //添加新的帖子评论
    public int addTb_comment(Invitation_comment comment);

    //更新帖子评论信息
    public int updateTb_comment(Invitation_comment comment);

    //根据帖子ID更新帖子评论的点赞数
    public int updateCnum(Integer id);

    //根据ID删除某个帖子评论
    public int deleteTb_comment(Integer id);
}
