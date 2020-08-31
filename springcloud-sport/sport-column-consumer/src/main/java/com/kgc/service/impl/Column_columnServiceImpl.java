package com.kgc.service.impl;

import com.kgc.client.Column_columnClient;
import com.kgc.pojo.Column_column;
import com.kgc.service.Column_columnService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Column_columnServiceImpl implements Column_columnService {
    @Autowired
    private Column_columnClient columnClient;
    /*
        分页，根据专栏名称，申请时间查询所有专栏
        并根据申请时间降序排列
     */
    @Override
    public PageUtil<Column_column> getAllColumn_column(String cname, String createtime, Integer pageIndex, Integer pageSize) {
        Map<String,Object> map=new HashMap<>();
        map.put("cname",cname);
        map.put("createtime",createtime);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        return columnClient.getAllColumn_column(map);
    }
    //根据专栏编号查询该专栏信息
    @Override
    public Column_column getColumnById(Integer id) {
        return columnClient.getColumnById(id);
    }
    //添加专栏
    @Override
    public int addColumn(Column_column column) {
        return columnClient.addColumn(column);
    }
    //更新专栏信息
    @Override
    public int updateColumn(Column_column column) {
        return columnClient.updateColumn(column);
    }
    //根据专栏编号删除专栏
    @Override
    public int deleteColumn(Integer id) {
        return columnClient.deleteColumn(id);
    }
}
