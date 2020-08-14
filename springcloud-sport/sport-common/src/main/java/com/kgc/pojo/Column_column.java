package com.kgc.pojo;

import java.io.Serializable;

/**
 * 专栏表实体类
 */
public class Column_column implements Serializable {
    //专栏编号
    private Integer id;
    //专栏名称
    private String cname;
    //专栏简介
    private String summary;
    //申请时间
    private String createtime;
    //审核时间
    private String checktime;
    //审核状态,0：未审核  1：已审核
    private String state;
    //用户编号
    private String userid;

    //无参构造方法
    public Column_column(){}

    /**
     * 带参构造方法
     * @param id 专栏编号
     * @param cname 专栏名称
     * @param summary 专栏简介
     * @param createtime 申请时间
     * @param checktime 审核时间
     * @param state 审核状态,0：未审核  1：已审核
     * @param userid 用户编号
     */
    public Column_column(Integer id, String cname, String summary, String createtime, String checktime, String state, String userid) {
        this.id = id;
        this.cname = cname;
        this.summary = summary;
        this.createtime = createtime;
        this.checktime = checktime;
        this.state = state;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
