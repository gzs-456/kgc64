package com.kgc.pojo;

import java.io.Serializable;

/**
 * 文章表实体类
 */
public class Column_article implements Serializable {
    //文章编号
    private Integer id;
    //文章标题
    private String title;
    //文章内容
    private String content;
    //文章封面
    private String image;
    //发表时间
    private String createtime;
    //修改时间
    private String updatetime;
    //是否公开,0：不公开 1：公开
    private String ispublic;
    //是否置顶,0：不置顶 1：置顶
    private String istop;
    //浏览量
    private Integer visits;
    //点赞数
    private Integer thumbup;
    //评论数
    private Integer acomment;
    //审核状态,0：未审核  1：已审核
    private String state;
    //URL地址
    private String url;
    //文章类型,0：普通 1：专栏
    private String atype;
    //专栏编号
    private Integer columnid;
    //用户编号
    private String userid;
    //专栏对象
    private Column_column column;

    //无参构造方法
    public Column_article(){}

    /**
     * 带参构造方法
     * @param id 文章编号
     * @param title 文章标题
     * @param content 文章内容
     * @param image 文章封面
     * @param createtime 发表时间
     * @param updatetime 修改时间
     * @param ispublic 是否公开,0：不公开 1：公开
     * @param istop 是否置顶,0：不置顶 1：置顶
     * @param visits 浏览量
     * @param thumbup 点赞数
     * @param acomment 评论数
     * @param state 审核状态,0：未审核  1：已审核
     * @param url URL地址
     * @param atype 文章类型,0：普通 1：专栏
     * @param columnid 专栏编号
     * @param userid 用户编号
     * @param column 专栏对象
     */
    public Column_article(Integer id, String title, String content, String image, String createtime, String updatetime, String ispublic, String istop, Integer visits, Integer thumbup, Integer acomment, String state, String url, String atype, Integer columnid, String userid, Column_column column) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.ispublic = ispublic;
        this.istop = istop;
        this.visits = visits;
        this.thumbup = thumbup;
        this.acomment = acomment;
        this.state = state;
        this.url = url;
        this.atype = atype;
        this.columnid = columnid;
        this.userid = userid;
        this.column = column;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getThumbup() {
        return thumbup;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }

    public Integer getAcomment() {
        return acomment;
    }

    public void setAcomment(Integer acomment) {
        this.acomment = acomment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public Integer getColumnid() {
        return columnid;
    }

    public void setColumnid(Integer columnid) {
        this.columnid = columnid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Column_column getColumn() {
        return column;
    }

    public void setColumn(Column_column column) {
        this.column = column;
    }
}
