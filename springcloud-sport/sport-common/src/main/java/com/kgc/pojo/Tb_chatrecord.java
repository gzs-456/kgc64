package com.kgc.pojo;

/**
 * 聊天记录表实体类
 */
public class Tb_chatrecord {
    private Integer id;//聊天记录编号
    private String putid;//发送方编号
    private String gainid;//接收方编号
    private String sendtime;//聊天时间
    private String content;//聊天内容

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
