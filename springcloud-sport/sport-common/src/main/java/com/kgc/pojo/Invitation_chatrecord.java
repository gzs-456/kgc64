package com.kgc.pojo;

import java.io.Serializable;

/**
 * 聊天记录表实体类
 */
public class Invitation_chatrecord implements Serializable {
    //聊天记录编号
    private Integer id;
    //发送方编号
    private String putid;
    //接收方编号
    private String gainid;
    //聊天时间
    private String sendtime;
    //聊天内容
    private String content;


    //不带参构造方法
    public Invitation_chatrecord(){}
    /**
     * 带参构造方法
     * @param id 聊天记录编号
     * @param putid 发送方编号
     * @param gainid 接收方编号
     * @param sendtime 聊天时间
     * @param content 聊天内容
     */
    public Invitation_chatrecord(Integer id, String putid, String gainid, String sendtime, String content) {
        this.id = id;
        this.putid = putid;
        this.gainid = gainid;
        this.sendtime = sendtime;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPutid() {
        return putid;
    }

    public void setPutid(String putid) {
        this.putid = putid;
    }

    public String getGainid() {
        return gainid;
    }

    public void setGainid(String gainid) {
        this.gainid = gainid;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
