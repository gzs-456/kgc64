package com.kgc.service.impl;

import com.kgc.client.Column_articleClient;
import com.kgc.pojo.Column_article;
import com.kgc.service.Column_articleService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class Column_articleServiceImpl implements Column_articleService {

    @Autowired
    private Column_articleClient articleClient;

    /*
        分页，根据文章标题，发表时间，浏览量，点赞数，评论数，文章类型,0：普通 1：专栏查询，
        并按照发表时间，浏览量，点赞数，评论数降序排列
     */
    @Override
    public PageUtil<Column_article> getArticlePage(String title, String createtime, String atype, Integer visits, Integer thumbup, Integer acomment, Integer pageIndex, Integer pageSize) {
        Map<String,Object> map=new HashMap<>();
        map.put("title",title);
        map.put("createtime",createtime);
        map.put("atype",atype);
        map.put("visits",visits);
        map.put("thumbup",thumbup);
        map.put("acomment",acomment);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        return articleClient.getArticlePage(map);
    }
    //根据标签编号查询所有的文章
    @Override
    public List<Column_article> getAllarticleByalid(Integer alid) {
        return articleClient.getAllarticleByalid(alid);
    }
    //根据专栏编号和文章类型,0：普通 1：专栏查询所有普通或专栏文章
    @Override
    public List<Column_article> getAllarticleBycolumnid(Integer columnid, String atype) {
        return articleClient.getAllarticleBycolumnid(columnid,atype);
    }
    //根据文章编号，查询该编号文章信息
    @Override
    public Column_article getarticleById(Integer id) {
        return articleClient.getarticleById(id);
    }
    //添加文章
    @Override
    public int addArticle(Column_article article) {
        return articleClient.addArticle(article);
    }
    //更新文章
    @Override
    public int updateArticle(Column_article article) {
        return articleClient.updateArticle(article);
    }
    //根据文章编号更新文章的浏览量
    @Override
    public int updateVisits(Integer id) {
        return articleClient.updateVisits(id);
    }
    //根据文章编号更新文章的点赞数
    @Override
    public int updateThumbup(Integer id) {
        return articleClient.updateThumbup(id);
    }
    //根据文章编号更新文章的评论数
    @Override
    public int updateAcomment(Integer id) {
        return articleClient.updateAcomment(id);
    }
    //根据文章编号删除文章
    @Override
    public int deleteArticle(Integer id) {
        return articleClient.deleteArticle(id);
    }
}
