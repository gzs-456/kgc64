package com.kgc.pojo;

/**
 * 帖子专区表实体类
 */
public class Invitation_area {
    private Integer id;//专区编号
    private String areaname;//专区名称
    private String introduce;//版块介绍
    private String areaAdmin;//版主或管理者
    private Integer clicknum;//专区点击数,默认为0
    private Integer introduceChildId;//专区子版块外键
    private Invitation_areaChild areaChild;//专区子版块对象

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

    public Invitation_areaChild getAreaChild() {
        return areaChild;
    }

    public void setAreaChild(Invitation_areaChild areaChild) {
        this.areaChild = areaChild;
    }

    public Integer getIntroduceChildId() {
        return introduceChildId;
    }

    public void setIntroduceChildId(Integer introduceChildId) {
        this.introduceChildId = introduceChildId;
    }
}
