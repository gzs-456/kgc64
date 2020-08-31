package com.kgc.service.impl;

import com.kgc.client.Column_commentClient;
import com.kgc.pojo.Column_comment;
import com.kgc.service.Column_commentService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Column_commentServiceImpl implements Column_commentService {
    @Autowired
    private Column_commentClient commentClient;
    /*
        分页，根据评论人昵称，评论时间，评论级别，文章类型,0：普通 1：专栏进行查询
        并根据评论时间降序排列
        并根据评论人昵称分组
     */
    @Override
    public PageUtil<Column_comment> getAllComment(String nickname, String publishdate, Integer parentid, String atype, Integer pageIndex, Integer pageSize) {
        Map<String,Object> map=new HashMap<>();
        map.put("nickname",nickname);
        map.put("publishdate",publishdate);
        map.put("parentid",parentid);
        map.put("atype",atype);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        return commentClient.getAllComment(map);
    }
    //根据文章编号，文章类型,0：普通 1：专栏来查询普通文章或是专栏文章的评论信息
    @Override
    public List<Column_comment> getCommentById(Integer articleid, String atype) {
        return commentClient.getCommentById(articleid,atype);
    }
    //添加评论
    @Override
    public int addComment(Column_comment comment) {
        return commentClient.addComment(comment);
    }
    //更新评论信息
    @Override
    public int updateComment(Column_comment comment) {
        return commentClient.updateComment(comment);
    }
    //根据评论编号，删除评论信息
    @Override
    public int deleteComment(Integer id) {
        return commentClient.deleteComment(id);
    }
}
