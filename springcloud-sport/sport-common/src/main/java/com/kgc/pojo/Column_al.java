package com.kgc.pojo;

/**
 * 文章标签表实体类
 */
public class Column_al {
    //文章标签编号
    private Integer id;
    //文章编号
    private Integer aid;
    //文章对象
    private Column_article article;

    //无参构造方法
    public Column_al(){}
    /**
     * 带参构造方法
     * @param id 文章标签编号
     * @param aid 文章编号
     * @param article 文章对象
     */
    public Column_al(Integer id, Integer aid, Column_article article) {
        this.id = id;
        this.aid = aid;
        this.article = article;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Column_article getArticle() {
        return article;
    }

    public void setArticle(Column_article article) {
        this.article = article;
    }
}
