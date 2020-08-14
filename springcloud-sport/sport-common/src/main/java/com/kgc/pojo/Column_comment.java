package com.kgc.pojo;

/**
 *评论表实体类
 */
public class Column_comment {
    //专栏评论编号
    private Integer id;
    //评论人昵称
    private String nickname;
    //评论人头像地址
    private String cpicture;
    //评论内容
    private String content;
    //评论日期
    private String publishdate;
    //文章编号
    private Integer articleid;
    //评论用户编号
    private String userid;
    //评论级别,如果为0表示文章的顶级评论
    private Integer parentid;
    //文章表对象
    private Column_article article;

    //无参构造方法
    public Column_comment(){}
    /**
     * 带参构造方法
     * @param id 专栏评论编号
     * @param nickname 评论人昵称
     * @param cpicture 评论人头像地址
     * @param content 评论内容
     * @param publishdate 评论日期
     * @param articleid 文章编号
     * @param userid 评论用户编号
     * @param parentid 评论级别,如果为0表示文章的顶级评论
     * @param article 文章表对象
     */
    public Column_comment(Integer id, String nickname, String cpicture, String content, String publishdate, Integer articleid, String userid, Integer parentid, Column_article article) {
        this.id = id;
        this.nickname = nickname;
        this.cpicture = cpicture;
        this.content = content;
        this.publishdate = publishdate;
        this.articleid = articleid;
        this.userid = userid;
        this.parentid = parentid;
        this.article = article;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCpicture() {
        return cpicture;
    }

    public void setCpicture(String cpicture) {
        this.cpicture = cpicture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Column_article getArticle() {
        return article;
    }

    public void setArticle(Column_article article) {
        this.article = article;
    }
}
