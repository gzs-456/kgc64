package com.kgc.client.impl;

import com.kgc.client.Invitation_friendClient;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class Invitation_friendClientImpl implements Invitation_friendClient {
    @Override
    public PageUtil getAllInvitation_friend(Map<String, Object> map) {
        return null;
    }

    @Override
    public int updateBz(String userid, String friendid, String bz) {
        return 0;
    }

    @Override
    public int updateislike(String userid, String friendid, String islike) {
        return 0;
    }

    @Override
    public int deletefriend(String userid, String friendid) {
        return 0;
    }


}
