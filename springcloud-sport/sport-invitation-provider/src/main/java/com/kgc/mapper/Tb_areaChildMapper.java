package com.kgc.mapper;

import com.kgc.pojo.Tb_areaChild;

import java.util.List;
import java.util.Map;

/**
 * 专区子版块表provider接口
 */
public interface Tb_areaChildMapper {
    //分页,根据专区子版块名称查询所有
    public List<Tb_areaChild> getTb_areaChildPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //查询所有的专区子版块信息
    public List<Tb_areaChild> getAllTb_areaChild();

    //根据专区子版块编号查询某一个专区子版块介绍信息
    public Tb_areaChild getTb_areaById(Integer id);

    //添加新的专区子版块
    public int addTb_areaChild(Tb_areaChild areaChild);

    //更新专区子版块信息
    public int updateTb_areaChild(Tb_areaChild areaChild);

    //根据专区子版块ID更新专区子版块的点击数
    public int updateClicknum(Integer id);

    //根据ID删除某个专区子版块
    public int deleteTb_areaChild(Integer id);
}
