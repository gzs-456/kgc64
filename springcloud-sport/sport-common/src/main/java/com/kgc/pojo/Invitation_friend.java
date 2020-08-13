package com.kgc.pojo;

import java.io.Serializable;

/**
 * 好友表实体类
 */
public class Invitation_friend implements Serializable {
    //自增长的一个ID
    private Integer id;
    //用户编号
    private String userid;
    //好友编号
    private String friendid;
    //好友备注
    private String bz;
    //是否相互关注，0 单向关注，1 双向关注
    private String islike;


    //不带参的构造方法
    public Invitation_friend(){}
    /**
     * 带参的构造方法
     * @param id 自增长的一个ID
     * @param userid 用户编号
     * @param friendid 好友编号
     * @param bz 好友备注
     * @param islike 是否相互关注，0 单向关注，1 双向关注
     */
    public Invitation_friend(Integer id, String userid, String friendid, String bz, String islike) {
        this.id = id;
        this.userid = userid;
        this.friendid = friendid;
        this.bz = bz;
        this.islike = islike;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }

    public String getIslike() {
        return islike;
    }

    public void setIslike(String islike) {
        this.islike = islike;
    }
}
