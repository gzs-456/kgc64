package com.kgc.pojo;

/**
 * 频道表实体类
 */
public class Column_channel {
    //频道编号
    private Integer id;
    //频道名称
    private String channelname;
    //状态,0：不公开 1：公开
    private String state;


    //无参构造方法
    public Column_channel(){}
    /**
     * 带参构造方法
     * @param id 频道编号
     * @param channelname 频道名称
     * @param state 状态,0：不公开 1：公开
     */
    public Column_channel(Integer id, String channelname, String state) {
        this.id = id;
        this.channelname = channelname;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
