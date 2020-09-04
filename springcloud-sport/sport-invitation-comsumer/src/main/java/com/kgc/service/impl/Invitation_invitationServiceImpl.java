package com.kgc.service.impl;

import com.kgc.client.Invitation_invitationClient;
import com.kgc.config.InvitationUtil;
import com.kgc.pojo.Invitation_invitation;
import com.kgc.service.Invitation_invitationService;
import com.kgc.util.*;
import com.kgc.vo.MqMessVo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.RabbitUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Invitation_invitationServiceImpl implements Invitation_invitationService {
    @Autowired
    private Invitation_invitationClient invitationClient;
    @Autowired
    private InvitationUtil invitationUtil;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisUtils redisUtils;
    //分页，模糊查询的条件有帖子标题，发布者昵称，点赞数，推荐数，浏览数，发布时间
    //可以根据点赞数，推荐数，浏览数，发布时间 降序排列
    @Override
    public PageUtil<Invitation_invitation> getTb_invitationPage(Invitation_invitation  invitation, Integer pageIndex, Integer pageSize) {
        //封装成一个map对象
        Map<String,Object>map=new HashMap<>();
        map.put("id",invitation.getId());
        map.put("title", invitation.getTitle());
        map.put("iname", invitation.getIname());
        map.put("content", invitation.getContent());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("ftime", invitation.getFtime());
        map.put("utime", invitation.getUtime());
        map.put("snum", invitation.getSnum());
        map.put("rnum", invitation.getRnum());
        map.put("seenum", invitation.getSeenum());
        //map.put("invitation",invitation);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        try {
            List<Invitation_invitation> list=new ArrayList<>();
            list=invitationClient.getTb_invitationPage(map).getList();
            invitationUtil.addDoc(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @Override
    public void initAssBRedis() {
        invitationClient.initAssBRedis();
    }

    @Override
    public Dto addInvitation(Integer userid, Integer invid) {
        MqMessVo mqMessVo = new MqMessVo();
        mqMessVo.setGoodsId(invid);
        mqMessVo.setToken(userid);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, "inform.sms.email", mqMessVo);
        return DtoUtil.returnSuccess("正在排队中");
    }

    @RabbitListener(queues = RabbitConfig.QUEQU_SMS)
    public void reviceQgMessage(MqMessVo messVo) {
        System.out.println(messVo);
        //分布式锁
        String key = "lock:" + messVo.getGoodsId();
        try {
            //后面的线程排队
            while (redisUtils.lock(key) == false) {
                Thread.sleep(500);
            }
            //3 锁定商品抢购
            int num = invitationClient.lockGoods(messVo.getGoodsId(), messVo.getToken());
            if (num == 0) {
                return;
            }
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            //解锁
            redisUtils.unlock(key);
        }
    }
}
