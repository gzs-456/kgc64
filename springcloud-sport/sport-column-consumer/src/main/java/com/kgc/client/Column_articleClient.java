package com.kgc.client;

import com.kgc.client.impl.Column_articleClientImpl;
import com.kgc.pojo.Column_article;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "sport-column-provider",fallback = Column_articleClientImpl.class)
public interface Column_articleClient {
    /*
        分页，根据文章标题，发表时间，浏览量，点赞数，评论数，文章类型,0：普通 1：专栏查询，
        并按照发表时间，浏览量，点赞数，评论数降序排列
     */
    @RequestMapping("/getArticlePage")
    public PageUtil getArticlePage(@RequestParam Map<String, Object> map);

    //根据标签编号查询所有的文章
    @RequestMapping("/getAllarticleByalid/{alid}")
    public List<Column_article> getAllarticleByalid(@PathVariable("alid") Integer alid);

    //根据专栏编号和文章类型,0：普通 1：专栏查询所有普通或专栏文章
    @RequestMapping("/getAllarticleBycolumnid")
    public List<Column_article>getAllarticleBycolumnid(@RequestParam(value = "columnid", required = false, defaultValue = "1") Integer columnid, @RequestParam(value = "atype", required = false, defaultValue = "1") String atype);

    //根据文章编号，查询该编号文章信息
    @RequestMapping("/getarticleById/{id}")
    public Column_article getarticleById(@PathVariable("id") Integer id);

    //添加文章
    @RequestMapping("/addArticle")
    public int addArticle(@RequestBody Column_article article);

    //更新文章
    @RequestMapping("/updateArticle")
    public int updateArticle(@RequestBody Column_article article);

    //根据文章编号更新文章的浏览量
    @RequestMapping("/updateVisits/{id}")
    public int updateVisits(@PathVariable("id") Integer id);

    //根据文章编号更新文章的点赞数
    @RequestMapping("/updateThumbup/{id}")
    public int updateThumbup(@PathVariable("id") Integer id);

    //根据文章编号更新文章的评论数
    @RequestMapping("/updateAcomment/{id}")
    public int updateAcomment(@PathVariable("id") Integer id);

    //根据文章编号删除文章
    @RequestMapping("/deleteArticle/{id}")
    public int deleteArticle(@PathVariable("id") Integer id);

}
