package com.kgc.pojo;

/**
 * 好友表实体类
 */
public class Tb_friend {
    private Integer id;
    private String userid;//用户编号
    private String friendid;//好友编号
    private String bz;//好友备注
    private String islike;//是否相互关注，0 单向关注，1 双向关注

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
