package com.kgc.mapper;

import com.kgc.pojo.Column_al;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Column_alMapper {
    //分页，查询所有的标签
    public List<Column_al>getAllColumn_al();

    //添加标签
    public int addColumn_al(Column_al al);

    //根据标签编号更新标签名
    public int updateColumn_al(Integer id);

}
