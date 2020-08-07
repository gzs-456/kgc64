package com.kgc.service.impl;

import com.kgc.client.Invitation_invitationClient;
import com.kgc.pojo.Invitation_invitation;
import com.kgc.service.Invitation_invitationService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Invitation_invitationServiceImpl implements Invitation_invitationService {
    @Autowired
    private Invitation_invitationClient invitationClient;
    //分页，模糊查询的条件有帖子标题，发布者昵称，点赞数，推荐数，浏览数，发布时间
    //可以根据点赞数，推荐数，浏览数，发布时间 降序排列
    @Override
    public PageUtil<Invitation_invitation> getTb_invitationPage(String title, String iname, String ftime, Integer snum, Integer rnum, Integer seenum, Integer pageIndex, Integer pageSize) {
        //封装成一个map对象
        Map<String,Object>map=new HashMap<>();
        map.put("title",title);
        map.put("iname",iname);
        map.put("ftime",ftime);
        map.put("snum",snum);
        map.put("rnum",rnum);
        map.put("seenum",seenum);
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        return invitationClient.getTb_invitationPage(map);
    }
    //根据帖子编号查询某一个帖子信息
    @Override
    public Invitation_invitation getTb_invitationById(Integer id) {
        return invitationClient.getTb_invitationById(id);
    }
    //添加新的帖子
    @Override
    public int addTb_invitation(Invitation_invitation invitation) {
        return invitationClient.addTb_invitation(invitation);
    }
    //更新帖子信息
    @Override
    public int updateTb_invitation(Invitation_invitation invitation) {
        return invitationClient.updateTb_invitation(invitation);
    }
    //根据帖子ID更新帖子点赞数
    @Override
    public int updateSnum(Integer id) {
        return invitationClient.updateSnum(id);
    }
    //根据帖子ID更新帖子推荐数
    @Override
    public int updateRnum(Integer id) {
        return invitationClient.updateRnum(id);
    }
    //根据帖子ID更新帖子浏览数
    @Override
    public int updateSeenum(Integer id) {
        return invitationClient.updateSeenum(id);
    }
    //据ID删除某个帖子
    @Override
    public int deleteTb_invitation(Integer id) {
        return invitationClient.deleteTb_invitation(id);
    }
}
