package com.kgc.mapper;

import com.kgc.pojo.Column_article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Column_articleMapper {
    /*
        分页，根据文章标题，发表时间，浏览量，点赞数，评论数，文章类型,0：普通 1：专栏查询，
        并按照发表时间，浏览量，点赞数，评论数降序排列
     */
    public List<Column_article>getAllColumn_article(Map<String, Object> map);
    public int getCount(Map<String, Object> map);

    //根据标签编号查询所有的文章
    public List<Column_article>getAllarticleByalid(Integer alid);

    //根据专栏编号和文章类型,0：普通 1：专栏查询所有专栏文章
    public List<Column_article>getAllarticleBycolumnid(Integer columnid,String atype);

    //根据文章编号，查询该编号文章信息
    public Column_article getarticleById(Integer id);

    //添加文章
    public int addArticle(Column_article article);

    //更新文章
    public int updateArticle(Column_article article);

    //根据文章编号更新文章的浏览量
    public int updateVisits(Integer id);

    //根据文章编号更新文章的点赞数
    public int updateThumbup(Integer id);

    //根据文章编号更新文章的评论数
    public int updateAcomment(Integer id);

    //根据文章编号删除文章
    public int deleteArticle(Integer id);
}
