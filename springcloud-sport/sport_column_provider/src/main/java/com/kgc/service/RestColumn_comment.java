package com.kgc.service;

import com.kgc.mapper.Column_commentMapper;
import com.kgc.pojo.Column_column;
import com.kgc.pojo.Column_comment;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestColumn_comment {
    @Autowired
    private Column_commentMapper commentMapper;

    /*
       分页，根据评论人昵称，评论时间，评论级别，文章类型,0：普通 1：专栏进行查询
       并根据评论时间降序排列
       并根据评论人昵称分组
    */
    @RequestMapping("/getAllComment")
    public PageUtil getAllComment(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = commentMapper.getCount(map);
        page.setTotalCount(count);
        //调用mapper方法
        List<Column_comment> list = commentMapper.getAllComment(map);
        page.setList(list);
        return page;
    }

    //根据文章编号，文章类型,0：普通 1：专栏来查询普通文章或是专栏文章的评论信息
    @RequestMapping("/getCommentById")
    public List<Column_comment> getCommentById(@RequestParam(value="articleid",required = false,defaultValue = "1")Integer articleid,@RequestParam(value="atype",required = false,defaultValue = "1")String atype){
        return commentMapper.getCommentById(articleid,atype);
    }

    //添加评论
    @RequestMapping("/addComment")
    public int addComment(@RequestBody Column_comment comment){
        return commentMapper.addComment(comment);
    }

    //更新评论信息
    @RequestMapping("/updateComment")
    public int updateComment(@RequestBody Column_comment comment){
        return commentMapper.updateComment(comment);
    }

    //根据评论编号，删除评论信息
    @RequestMapping("/deleteComment/{id}")
    public int deleteComment(@PathVariable("id") Integer id){
        return commentMapper.deleteComment(id);
    }
}
