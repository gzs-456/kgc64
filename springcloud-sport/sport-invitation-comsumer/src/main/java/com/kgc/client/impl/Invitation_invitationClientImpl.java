package com.kgc.client.impl;

import com.kgc.client.Invitation_invitationClient;
import com.kgc.pojo.Invitation_invitation;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class Invitation_invitationClientImpl implements Invitation_invitationClient {
    @Override
    public PageUtil getTb_invitationPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public Invitation_invitation getTb_invitationById(Integer id) {
        return null;
    }

    @Override
    public int addTb_invitation(Invitation_invitation invitation) {
        return 0;
    }

    @Override
    public int updateTb_invitation(Invitation_invitation invitation) {
        return 0;
    }

    @Override
    public int updateSnum(Integer id) {
        return 0;
    }

    @Override
    public int updateRnum(Integer id) {
        return 0;
    }

    @Override
    public int updateSeenum(Integer id) {
        return 0;
    }

    @Override
    public int deleteTb_invitation(Integer id) {
        return 0;
    }
}
