package com.kgc.pojo;

import java.io.Serializable;

public class User_follow implements Serializable {
    private Integer userid;
    private Integer targetuser;

    public User_follow(Integer userid, Integer targetuser) {
        this.userid = userid;
        this.targetuser = targetuser;
    }

    public User_follow() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTargetuser() {
        return targetuser;
    }

    public void setTargetuser(Integer targetuser) {
        this.targetuser = targetuser;
    }
}
