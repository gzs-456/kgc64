package com.kgc.client.impl;

import com.kgc.client.Invitation_chatrecordClient;
import com.kgc.pojo.Invitation_chatrecord;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class Invitation_chatrecordClientImpl implements Invitation_chatrecordClient {
    @Override
    public PageUtil<Invitation_chatrecord> getAllInvitation_chatrecord(Map<String, Object> map) {
        return null;
    }

    @Override
    public int addcontent(Invitation_chatrecord invitation_chatrecord) {
        return 0;
    }
}
