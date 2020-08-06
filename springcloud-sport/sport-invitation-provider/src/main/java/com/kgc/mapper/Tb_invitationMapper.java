package com.kgc.mapper;

import com.kgc.pojo.Invitation_invitation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 帖子表provider接口
 */
@Mapper
public interface Tb_invitationMapper {
    //分页，模糊查询的条件有帖子标题，发布者昵称，点赞数，推荐数，浏览数，发布时间
    //可以根据点赞数，推荐数，浏览数，发布时间 降序排列
    public List<Invitation_invitation>getTb_invitationPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //帖子表，专区表两表连接查询
    public List<Invitation_invitation> getTb_invitationAndTb_area();

    //帖子表，评论表两表连接查询
    public List<Invitation_invitation> getTb_invitationAndTb_comment();

    //根据帖子编号查询某一个帖子信息
    public Invitation_invitation getTb_invitationById(Integer id);

    //添加新的帖子
    public int addTb_invitation(Invitation_invitation invitation);

    //更新帖子信息
    public int updateTb_invitation(Invitation_invitation invitation);

    //根据帖子ID更新帖子点赞数
    public int updateSnum(Integer id);

    //根据帖子ID更新帖子推荐数
    public int updateRnum(Integer id);

    //根据帖子ID更新帖子浏览数
    public int updateSeenum(Integer id);

    //据ID删除某个帖子
    public int deleteTb_invitation(Integer id);
}
