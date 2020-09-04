package com.kgc.vo;

import java.io.Serializable;

/**
 * 消息中间件
 */
public class MqMessVo implements Serializable {

    private Integer token;
    private Integer goodsId;


    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
