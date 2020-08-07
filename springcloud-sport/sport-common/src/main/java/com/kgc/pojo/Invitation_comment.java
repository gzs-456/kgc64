package com.kgc.pojo;

import java.io.Serializable;

/**
 * 帖子评论表实体类
 */
public class Invitation_comment implements Serializable {
    //评论编号
    private Integer id;
    //评论人名称
    private String cname;
    //评论内容
    private String content;
    //评论时间
    private String ctime;
    //评论人头像地址
    private String cpicture;
    //评论点赞数
    private Integer cnum;
    //帖子外键
    private Integer invitationId;
    //帖子对象
    private Invitation_invitation invitation;

    //不带参构造方法
    public Invitation_comment(){}
    /**
     * 带参构造方法
     * @param id 评论编号
     * @param cname 评论人名称
     * @param content 评论内容
     * @param ctime 评论时间
     * @param cpicture 评论人头像地址
     * @param cnum 评论点赞数
     * @param invitationId 帖子外键
     * @param invitation 帖子对象
     */
    public Invitation_comment(Integer id, String cname, String content, String ctime, String cpicture, Integer cnum, Integer invitationId, Invitation_invitation invitation) {
        this.id = id;
        this.cname = cname;
        this.content = content;
        this.ctime = ctime;
        this.cpicture = cpicture;
        this.cnum = cnum;
        this.invitationId = invitationId;
        this.invitation = invitation;
    }

    public Invitation_invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation_invitation invitation) {
        this.invitation = invitation;
    }

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCpicture() {
        return cpicture;
    }

    public void setCpicture(String cpicture) {
        this.cpicture = cpicture;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }
}
