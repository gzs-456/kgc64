package com.kgc.pojo;

/**
 * 专区子版块表实体类
 */
public class Tb_areaChild {
    private Integer id;//专区子版块编号
    private String introduce;//专区子版块介绍
    private String areaAdmin;//专区子版块版主或管理者
    private Integer clicknum;//专区点击数,默认为0

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
