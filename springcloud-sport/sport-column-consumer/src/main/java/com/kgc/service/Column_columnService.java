package com.kgc.service;

import com.kgc.pojo.Column_column;
import com.kgc.util.PageUtil;

public interface Column_columnService {
    /*
        分页，根据专栏名称，申请时间查询所有专栏
        并根据申请时间降序排列
     */
    public PageUtil<Column_column> getAllColumn_column(String cname, String createtime, Integer pageIndex, Integer pageSize);

    //根据专栏编号查询该专栏信息
    public Column_column getColumnById(Integer id);

    //添加专栏
    public int addColumn(Column_column column);

    //更新专栏信息
    public int updateColumn(Column_column column);

    //根据专栏编号删除专栏
    public int deleteColumn(Integer id);
}
