package com.kgc.vo;

import java.io.Serializable;

/**
 * token结构
 */
public class UserTokenVo implements Serializable {
        private String token;
        private Long genTime;
        private Long expTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGenTime() {
        return genTime;
    }

    public void setGenTime(Long genTime) {
        this.genTime = genTime;
    }

    public Long getExpTime() {
        return expTime;
    }

    public void setExpTime(Long expTime) {
        this.expTime = expTime;
    }
}
