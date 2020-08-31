package com.kgc.client.impl;

import com.kgc.client.Column_alClient;
import com.kgc.pojo.Column_al;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Column_alClientImpl implements Column_alClient {
    @Override
    public List<Column_al> getAllColumn_al() {
        return null;
    }

    @Override
    public int addColumn_al(Column_al al) {
        return 0;
    }

    @Override
    public int updateColumn_al(Column_al al) {
        return 0;
    }

    @Override
    public int deleteColumn_al(Integer id) {
        return 0;
    }
}
