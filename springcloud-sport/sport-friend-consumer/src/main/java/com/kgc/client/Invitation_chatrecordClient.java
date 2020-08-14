package com.kgc.client;

import com.kgc.pojo.Invitation_chatrecord;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@FeignClient(name="sport-friend-provider")
public interface Invitation_chatrecordClient {
    //分页，根据发送方和接收方编号查询所有聊天信息,并按照发送时间降序排列
    @RequestMapping("/getAllInvitation_chatrecord")
    public PageUtil<Invitation_chatrecord> getAllInvitation_chatrecord(@RequestParam Map<String, Object> map);
    //添加聊天记录
    @RequestMapping("/addcontent")
    public int addcontent(@RequestBody Invitation_chatrecord invitation_chatrecord);
}
