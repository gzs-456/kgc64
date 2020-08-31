package com.kgc.controller;

import com.kgc.pojo.Column_article;
import com.kgc.service.Column_articleService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class Column_articleController {
    @Autowired
    private Column_articleService articleService;

    /*
        分页，根据文章标题，发表时间，浏览量，点赞数，评论数，文章类型,0：普通 1：专栏查询，
        并按照发表时间，浏览量，点赞数，评论数降序排列
     */
    @RequestMapping("/getArticlePage")
    public PageUtil getArticlePage(String title,String createtime,String atype,Integer visits,Integer thumbup,Integer acomment,
        @RequestParam(value = "pageIndex", defaultValue = "1")Integer pageIndex,
        @RequestParam(value = "pageSize", defaultValue = "2")Integer pageSize){
        return articleService.getArticlePage(title,createtime,atype,visits,thumbup,acomment,pageIndex,pageSize);
    }

    //根据标签编号查询所有的文章
    @RequestMapping("/getAllarticleByalid")
    public List<Column_article> getAllarticleByalid( Integer alid){
        return articleService.getAllarticleByalid(alid);
    }

    //根据专栏编号和文章类型,0：普通 1：专栏查询所有普通或专栏文章
    @RequestMapping("/getAllarticleBycolumnid")
    public List<Column_article>getAllarticleBycolumnid(Integer columnid,String atype){
        return articleService.getAllarticleBycolumnid(columnid,atype);
    }

    //根据文章编号，查询该编号文章信息
    @RequestMapping("/getarticleById")
    public Column_article getarticleById( Integer id){
        return articleService.getarticleById(id);
    }

    //添加文章
    @RequestMapping("/addArticle")
    public int addArticle(Column_article article){
        return articleService.addArticle(article);
    }

    //更新文章
    @RequestMapping("/updateArticle")
    public int updateArticle(Column_article article){
        return articleService.updateArticle(article);
    }

    //根据文章编号更新文章的浏览量
    @RequestMapping("/updateVisits")
    public int updateVisits(Integer id){
        return articleService.updateVisits(id);
    }

    //根据文章编号更新文章的点赞数
    @RequestMapping("/updateThumbup")
    public int updateThumbup(Integer id){
        return articleService.updateThumbup(id);
    }

    //根据文章编号更新文章的评论数
    @RequestMapping("/updateAcomment")
    public int updateAcomment (Integer id){
        return articleService.updateAcomment(id);
    }

    //根据文章编号删除文章
    @RequestMapping("/deleteArticle")
    public int deleteArticle(Integer id){
        return articleService.deleteArticle(id);
    }
}
