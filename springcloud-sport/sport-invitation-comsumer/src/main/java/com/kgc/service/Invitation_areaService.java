package com.kgc.service;

import com.kgc.pojo.Invitation_area;
import com.kgc.util.PageUtil;

import java.util.List;


public interface Invitation_areaService {
    //分页,根据专区名称查询所有
    public PageUtil<Invitation_area> getTb_areaPage(String areaname,Integer pageIndex,Integer pageSize);

    //帖子表，专区表两表连接查询,根据帖子编号查询所有专区
    public List<Invitation_area> getByinvitationId(Integer invitationId);

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
