package com.kgc.pojo;

import java.io.Serializable;

/**
 * 专区子版块表实体类
 */
public class Invitation_areaChild implements Serializable {
    //专区子版块编号
    private Integer id;
    //专区子版块名称
    private String areaname;
    //专区子版块介绍
    private String introduce;
    //专区子版块版主或管理者
    private String areaAdmin;
    //专区点击数,默认为0
    private Integer clicknum;
    //帖子外键
    private Integer invitationId;
    //专区外键
    private Integer areaId;
    //帖子对象
    private Invitation_invitation invitation;
    //专区对象
    private Invitation_area area;

    //不带参构造方法
    public Invitation_areaChild(){}
    /**
     * 带参构造方法
     * @param id 专区子版块编号
     * @param areaname 专区子版块名称
     * @param introduce 专区子版块介绍
     * @param areaAdmin 专区子版块版主或管理者
     * @param clicknum 专区点击数,默认为0
     * @param invitationId 帖子外键
     * @param areaId 专区外键
     * @param invitation 帖子对象
     * @param area 专区对象
     */
    public Invitation_areaChild(Integer id, String areaname, String introduce, String areaAdmin, Integer clicknum, Integer invitationId, Integer areaId, Invitation_invitation invitation, Invitation_area area) {
        this.id = id;
        this.areaname = areaname;
        this.introduce = introduce;
        this.areaAdmin = areaAdmin;
        this.clicknum = clicknum;
        this.invitationId = invitationId;
        this.areaId = areaId;
        this.invitation = invitation;
        this.area = area;
    }

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

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Invitation_invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation_invitation invitation) {
        this.invitation = invitation;
    }

    public Invitation_area getArea() {
        return area;
    }

    public void setArea(Invitation_area area) {
        this.area = area;
    }
}
