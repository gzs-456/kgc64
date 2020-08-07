package com.kgc.pojo;

/**
 * 专区子版块表实体类
 */
public class Invitation_areaChild {
    private Integer id;//专区子版块编号
    private String areaname;//专区子版块名称
    private String introduce;//专区子版块介绍
    private String areaAdmin;//专区子版块版主或管理者
    private Integer clicknum;//专区点击数,默认为0
    private Integer invitationId;//帖子外键
    private Integer areaId;//专区外键
    private Invitation_invitation invitation;//帖子对象
    private Invitation_area area;//专区对象

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
