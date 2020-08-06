package com.kgc.mapper;

import com.kgc.pojo.Tb_area;

import java.util.List;
import java.util.Map;

/**
 * 帖子专区表provider接口
 */
public interface Tb_areaMapper {
    //分页,根据专区名称查询所有
    public List<Tb_area> getTb_areaPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //查询所有的专区信息
    public List<Tb_area> getAllTb_area();

    //根据专区编号查询某一个专区介绍信息
    public Tb_area getTb_areaById(Integer id);

    //添加新的专区
    public int addTb_area(Tb_area area);

    //更新专区信息
    public int updateTb_area(Tb_area area);

    //根据专区ID更新专区的点击数
    public int updateClicknum(Integer id);

    //根据ID删除某个专区
    public int deleteTb_area(Integer id);

}
