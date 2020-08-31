package com.kgc.client.impl;

import com.kgc.client.Column_columnClient;
import com.kgc.pojo.Column_column;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class Column_columnClientImpl implements Column_columnClient {
    @Override
    public PageUtil getAllColumn_column(Map<String, Object> map) {
        return null;
    }

    @Override
    public Column_column getColumnById(Integer id) {
        return null;
    }

    @Override
    public int addColumn(Column_column column) {
        return 0;
    }

    @Override
    public int updateColumn(Column_column column) {
        return 0;
    }

    @Override
    public int deleteColumn(Integer id) {
        return 0;
    }
}
