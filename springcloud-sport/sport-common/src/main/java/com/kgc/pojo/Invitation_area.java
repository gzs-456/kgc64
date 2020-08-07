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
    private Integer invitationId;//帖子外键
    private Invitation_invitation invitation;//帖子对象

    public Invitation_invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation_invitation invitation) {
        this.invitation = invitation;
    }

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

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

}
