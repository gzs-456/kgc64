package com.kgc.controller;

import com.kgc.pojo.Column_comment;
import com.kgc.service.Column_commentService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class Column_commentController {
    @Autowired
    private Column_commentService commentService;


    /*
      分页，根据评论人昵称，评论时间，评论级别，文章类型,0：普通 1：专栏进行查询
      并根据评论时间降序排列
      并根据评论人昵称分组
   */
    @RequestMapping("/getAllComment")
    public PageUtil getAllComment(String nickname,String publishdate,Integer parentid,String atype,
                                  @RequestParam(value = "pageIndex", defaultValue = "1")Integer pageIndex,
                                  @RequestParam(value = "pageSize", defaultValue = "2")Integer pageSize){
        return commentService.getAllComment(nickname,publishdate,parentid,atype,pageIndex,pageSize);
    }

    //根据文章编号，文章类型,0：普通 1：专栏来查询普通文章或是专栏文章的评论信息
    @RequestMapping("/getCommentById")
    public List<Column_comment> getCommentById(Integer articleid, String atype){
        return commentService.getCommentById(articleid,atype);
    }

    //添加评论
    @RequestMapping("/addComment")
    public int addComment( Column_comment comment){
        return commentService.addComment(comment);
    }

    //更新评论信息
    @RequestMapping("/updateComment")
    public int updateComment( Column_comment comment){
        return commentService.updateComment(comment);
    }

    //根据评论编号，删除评论信息
    @RequestMapping("/deleteComment")
    public int deleteComment( Integer id){
        return commentService.deleteComment(id);
    }
}
