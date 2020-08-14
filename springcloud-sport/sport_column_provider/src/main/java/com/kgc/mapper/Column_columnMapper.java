package com.kgc.mapper;

import com.kgc.pojo.Column_column;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Column_columnMapper {
    /*
        分页，根据专栏名称，申请时间查询所有专栏
        并根据申请时间降序排列
     */
    public List<Column_column>getAllColumn_column(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //根据专栏编号查询该专栏信息
    public Column_column getColumnById(Integer id);

    //添加专栏
    public int addColumn(Column_column column);

    //更新专栏信息
    public int updateColumn(Column_column column);

    //根据专栏编号删除专栏
    public int deleteColumn(Integer id);
}
