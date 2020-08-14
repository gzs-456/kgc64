package com.kgc.pojo;

/**
 * 文章标签表实体类
 */
public class Column_al {
    //文章标签编号
    private Integer id;
    //标签名
    private String content;

    //无参构造方法
    public Column_al(){}

    /**
     * 带参构造方法
     * @param id 文章标签编号
     * @param content 标签名
     */
    public Column_al(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
