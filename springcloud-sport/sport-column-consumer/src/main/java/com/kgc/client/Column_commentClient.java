package com.kgc.client;

import com.kgc.client.impl.Column_commentClientImpl;
import com.kgc.pojo.Column_comment;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "sport-column-provider",fallback = Column_commentClientImpl.class)
public interface Column_commentClient {
    /*
       分页，根据评论人昵称，评论时间，评论级别，文章类型,0：普通 1：专栏进行查询
       并根据评论时间降序排列
       并根据评论人昵称分组
    */
    @RequestMapping("/getAllComment")
    public PageUtil getAllComment(@RequestParam Map<String, Object> map);

    //根据文章编号，文章类型,0：普通 1：专栏来查询普通文章或是专栏文章的评论信息
    @RequestMapping("/getCommentById")
    public List<Column_comment> getCommentById(@RequestParam(value = "articleid", required = false, defaultValue = "1") Integer articleid, @RequestParam(value = "atype", required = false, defaultValue = "1") String atype);

    //添加评论
    @RequestMapping("/addComment")
    public int addComment(@RequestBody Column_comment comment);

    //更新评论信息
    @RequestMapping("/updateComment")
    public int updateComment(@RequestBody Column_comment comment);

    //根据评论编号，删除评论信息
    @RequestMapping("/deleteComment/{id}")
    public int deleteComment(@PathVariable("id") Integer id);
}
