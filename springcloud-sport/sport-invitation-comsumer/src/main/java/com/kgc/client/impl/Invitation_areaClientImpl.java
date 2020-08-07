package com.kgc.client.impl;

import com.kgc.client.Invitation_areaClient;
import com.kgc.pojo.Invitation_area;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class Invitation_areaClientImpl implements Invitation_areaClient {
    @Override
    public PageUtil getTb_areaPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Invitation_area> getByinvitationId(Integer invitationId) {
        return null;
    }

    @Override
    public Invitation_area getTb_areaById(Integer id) {
        return null;
    }

    @Override
    public int addTb_area(Invitation_area area) {
        return 0;
    }

    @Override
    public int updateTb_area(Invitation_area area) {
        return 0;
    }

    @Override
    public int updateClicknum(Integer id) {
        return 0;
    }

    @Override
    public int deleteTb_area(Integer id) {
        return 0;
    }
}
