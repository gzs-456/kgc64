package com.kgc.service;

import com.kgc.pojo.Column_al;

import java.util.List;

public interface Column_alService {
    //查询所有的标签
    public List<Column_al> getAllColumn_al();

    //添加标签
    public int addColumn_al(Column_al al);

    //根据标签编号更新标签名
    public int updateColumn_al(Column_al al);

    //根据标签编号删除标签
    public int deleteColumn_al(Integer id);
}
