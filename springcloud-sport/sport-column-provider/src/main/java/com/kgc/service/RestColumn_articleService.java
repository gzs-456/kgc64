package com.kgc.service;

import com.kgc.mapper.Column_articleMapper;
import com.kgc.pojo.Column_article;
import com.kgc.pojo.Invitation_area;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class RestColumn_articleService {
    @Autowired
    private Column_articleMapper articleMapper;

    /*
        分页，根据文章标题，发表时间，浏览量，点赞数，评论数，文章类型,0：普通 1：专栏查询，
        并按照发表时间，浏览量，点赞数，评论数降序排列
     */
    @RequestMapping("/getArticlePage")
    public PageUtil getArticlePage(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = articleMapper.getCount(map);
        page.setTotalCount(count);
        //调用mapper方法
        List<Column_article> list = articleMapper.getArticlePage(map);
        page.setList(list);
        return page;
    }

    //根据标签编号查询所有的文章
    @RequestMapping("/getAllarticleByalid/{alid}")
    public List<Column_article>getAllarticleByalid(@PathVariable("alid") Integer alid){
        return articleMapper.getAllarticleByalid(alid);
    }

    //根据专栏编号和文章类型,0：普通 1：专栏查询所有普通或专栏文章
    @RequestMapping("/getAllarticleBycolumnid")
    public List<Column_article>getAllarticleBycolumnid(@RequestParam(value="columnid",required = false,defaultValue = "1") Integer columnid,@RequestParam(value="atype",required = false,defaultValue = "1")String atype){
        return articleMapper.getAllarticleBycolumnid(columnid,atype);
    }

    //根据文章编号，查询该编号文章信息
    @RequestMapping("/getarticleById/{id}")
    public Column_article getarticleById(@PathVariable("id") Integer id){
        return articleMapper.getarticleById(id);
    }

    //添加文章
    @RequestMapping("/addArticle")
    public int addArticle(@RequestBody Column_article article){
        return articleMapper.addArticle(article);
    }

    //更新文章
    @RequestMapping("/updateArticle")
    public int updateArticle(@RequestBody Column_article article){
        return articleMapper.updateArticle(article);
    }

    //根据文章编号更新文章的浏览量
    @RequestMapping("/updateVisits/{id}")
    public int updateVisits(@PathVariable("id") Integer id){
        return articleMapper.updateVisits(id);
    }

    //根据文章编号更新文章的点赞数
    @RequestMapping("/updateThumbup/{id}")
    public int updateThumbup(@PathVariable("id") Integer id){
        return articleMapper.updateThumbup(id);
    }

    //根据文章编号更新文章的评论数
    @RequestMapping("/updateAcomment/{id}")
    public int updateAcomment(@PathVariable("id") Integer id){
        return articleMapper.updateAcomment(id);
    }

    //根据文章编号删除文章
    @RequestMapping("/deleteArticle/{id}")
    public int deleteArticle(@PathVariable("id") Integer id){
        return articleMapper.deleteArticle(id);
    }
}
