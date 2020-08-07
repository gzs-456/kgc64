package com.kgc.mapper;

import com.kgc.pojo.Invitation_area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 帖子专区表provider接口
 */
@Mapper
public interface Tb_areaMapper {
    //分页
    public List<Invitation_area> getTb_areaPage(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //帖子表，专区表两表连接查询,根据帖子编号查询所有专区
    public List<Invitation_area> getById(Integer invitationId);

    //查询所有的专区信息
    public List<Invitation_area> getAllTb_area();

    //根据专区编号查询某一个专区介绍信息
    public Invitation_area getTb_areaById(Integer id);

    //添加新的专区
    public int addTb_area(Invitation_area area);

    //更新专区信息
    public int updateTb_area(Invitation_area area);

    //根据专区ID更新专区的点击数
    public int updateClicknum(Integer id);

    //根据ID删除某个专区
    public int deleteTb_area(Integer id);

}
