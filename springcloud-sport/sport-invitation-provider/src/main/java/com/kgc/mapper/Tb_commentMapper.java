package com.kgc.mapper;


import com.kgc.pojo.Tb_comment;

import java.util.List;
import java.util.Map;

/**
 * 帖子评论表provider接口
 */
public interface Tb_commentMapper {
    //分页，根据帖子编号查询所有
    public List<Tb_comment>getTb_commentPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //根据帖子编号查询某一个帖子评论信息
    public Tb_comment getTb_commentById(Integer id);

    //添加新的帖子评论
    public int addTb_comment(Tb_comment comment);

    //更新帖子评论信息
    public int updateTb_comment(Tb_comment comment);

    //根据帖子ID更新帖子评论的点赞数
    public int updateCnum(Integer id);

    //根据ID删除某个帖子评论
    public int deleteTb_comment(Integer id);
}
