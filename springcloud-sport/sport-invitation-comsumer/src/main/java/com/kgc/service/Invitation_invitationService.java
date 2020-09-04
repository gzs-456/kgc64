package com.kgc.service;

import com.kgc.pojo.Invitation_invitation;
import com.kgc.util.Dto;
import com.kgc.util.PageUtil;

import java.util.List;


public interface Invitation_invitationService {
    //分页，模糊查询的条件有帖子标题，发布者昵称，点赞数，推荐数，浏览数，发布时间
    //可以根据点赞数，推荐数，浏览数，发布时间 降序排列
    public PageUtil<Invitation_invitation> getTb_invitationPage(Invitation_invitation  invitation,Integer pageIndex,Integer pageSize);

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

    //查询全部
    public void initAssBRedis();
    //添加信息
    public Dto addInvitation(Integer userid , Integer invid);
}
