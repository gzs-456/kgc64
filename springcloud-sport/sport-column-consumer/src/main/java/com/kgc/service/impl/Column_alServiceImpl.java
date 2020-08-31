package com.kgc.service.impl;

import com.kgc.client.Column_alClient;
import com.kgc.pojo.Column_al;
import com.kgc.service.Column_alService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Column_alServiceImpl implements Column_alService {
    @Autowired
    private Column_alClient alClient;

    //查询所有的标签
    @Override
    public List<Column_al> getAllColumn_al() {
        return alClient.getAllColumn_al();
    }

    //添加标签
    @Override
    public int addColumn_al(Column_al al) {
        return alClient.addColumn_al(al);
    }

    //根据标签编号更新标签名
    @Override
    public int updateColumn_al(Column_al al) {
        return alClient.updateColumn_al(al);
    }

    //根据标签编号删除标签
    @Override
    public int deleteColumn_al(Integer id) {
        return alClient.deleteColumn_al(id);
    }
}
