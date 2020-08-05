package com.kgc.pojo;

/**
 * 帖子表实体类
 */
public class Tb_invitation {
    private Integer id;//帖子编号
    private String title;//帖子标题
    private String iname;//发布者昵称
    private String content;//帖子内容
    private String ftime;//发布时间
    private String utime;//修改时间
    private Integer snum;//点赞数，默认为0
    private Integer rnum;//推荐数，默认为0
    private Integer seenum;//浏览数，默认为0
    private Tb_area area;//专区对象
    private Tb_comment comment;//评论对象


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

    public Tb_area getArea() {
        return area;
    }

    public void setArea(Tb_area area) {
        this.area = area;
    }

    public Tb_comment getComment() {
        return comment;
    }

    public void setComment(Tb_comment comment) {
        this.comment = comment;
    }
}
