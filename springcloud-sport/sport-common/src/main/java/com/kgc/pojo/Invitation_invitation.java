package com.kgc.pojo;

import java.io.Serializable;

/**
 * 帖子表实体类
 */
public class Invitation_invitation implements Serializable {
    //帖子编号
    private Integer id;
    //帖子标题
    private String title;
    //发布者昵称
    private String iname;
    //帖子内容
    private String content;
    //发布时间
    private String ftime;
    //修改时间
    private String utime;
    //点赞数，默认为0
    private Integer snum;
    //推荐数，默认为0
    private Integer rnum;
    //浏览数，默认为0
    private Integer seenum;

    //不带参构造方法
    public Invitation_invitation(){}
    /**
     * 带参构造方法
     * @param id 帖子编号
     * @param title 帖子标题
     * @param iname 发布者昵称
     * @param content 帖子内容
     * @param ftime 发布时间
     * @param utime 修改时间
     * @param snum 点赞数，默认为0
     * @param rnum 推荐数，默认为0
     * @param seenum 浏览数，默认为0
     */
    public Invitation_invitation(Integer id, String title, String iname, String content, String ftime, String utime, Integer snum, Integer rnum, Integer seenum) {
        this.id = id;
        this.title = title;
        this.iname = iname;
        this.content = content;
        this.ftime = ftime;
        this.utime = utime;
        this.snum = snum;
        this.rnum = rnum;
        this.seenum = seenum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

    public Integer getSeenum() {
        return seenum;
    }

    public void setSeenum(Integer seenum) {
        this.seenum = seenum;
    }

}
