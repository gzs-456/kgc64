package com.kgc.pojo;

/**
 * 帖子专区表实体类
 */
public class Tb_area {
    private Integer id;//专区编号
    private String areaname;//专区名称
    private String introduce;//版块介绍
    private String areaAdmin;//版主或管理者
    private Integer clicknum;//专区点击数,默认为0
    private Tb_areaChild areaChild;//专区子版块对象

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAreaAdmin() {
        return areaAdmin;
    }

    public void setAreaAdmin(String areaAdmin) {
        this.areaAdmin = areaAdmin;
    }

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer clicknum) {
        this.clicknum = clicknum;
    }

    public Tb_areaChild getAreaChild() {
        return areaChild;
    }

    public void setAreaChild(Tb_areaChild areaChild) {
        this.areaChild = areaChild;
    }
}
