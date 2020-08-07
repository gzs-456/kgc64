package com.kgc.client.impl;

import com.kgc.client.Invitation_areaChildClient;
import com.kgc.pojo.Invitation_areaChild;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class Invitation_areaChildClientImpl implements Invitation_areaChildClient {

    @Override
    public PageUtil getTb_areaChildPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Invitation_areaChild> getByinvitationId(Integer invitationId) {
        return null;
    }

    @Override
    public List<Invitation_areaChild> getByareaId(Integer areaId) {
        return null;
    }

    @Override
    public Invitation_areaChild getTb_areaById(Integer id) {
        return null;
    }

    @Override
    public int addTb_areaChild(Invitation_areaChild areaChild) {
        return 0;
    }

    @Override
    public int updateTb_areaChild(Invitation_areaChild areaChild) {
        return 0;
    }

    @Override
    public int updateClicknum(Integer id) {
        return 0;
    }

    @Override
    public int deleteTb_areaChild(Integer id) {
        return 0;
    }
}
