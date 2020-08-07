package com.kgc.client.impl;

import com.kgc.client.Invitation_commentClient;
import com.kgc.pojo.Invitation_comment;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class Invitation_commentClientImpl implements Invitation_commentClient {
    @Override
    public PageUtil getTb_commentPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public int addTb_comment(Invitation_comment comment) {
        return 0;
    }

    @Override
    public int updateTb_comment(Invitation_comment comment) {
        return 0;
    }

    @Override
    public int updateCnum(Integer id) {
        return 0;
    }

    @Override
    public int deleteTb_comment(Integer id) {
        return 0;
    }
}
