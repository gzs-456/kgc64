package com.kgc.pojo;

import java.io.Serializable;

/**
 * 帖子专区表实体类
 */
public class Invitation_area implements Serializable {
    //专区编号
    private Integer id;
    //专区名称
    private String areaname;
    //版块介绍
    private String introduce;
    //版主或管理者
    private String areaAdmin;
    //专区点击数,默认为0
    private Integer clicknum;
    //帖子外键
    private Integer invitationId;
    //帖子对象
    private Invitation_invitation invitation;

    //不带参构造方法
    public Invitation_area(){ }
    /**
     * 带惨构造方法
     * @param id 专区编号
     * @param areaname 专区名称
     * @param introduce 版块介绍
     * @param areaAdmin 版主或管理者
     * @param clicknum 专区点击数,默认为0
     * @param invitationId 帖子外键
     * @param invitation 帖子对象
     */
    public Invitation_area(Integer id, String areaname, String introduce, String areaAdmin, Integer clicknum, Integer invitationId, Invitation_invitation invitation) {
        this.id = id;
        this.areaname = areaname;
        this.introduce = introduce;
        this.areaAdmin = areaAdmin;
        this.clicknum = clicknum;
        this.invitationId = invitationId;
        this.invitation = invitation;
    }

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
