package com.kgc.service;

import com.kgc.mapper.Tb_commentMapper;
import com.kgc.pojo.Invitation_comment;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestInvitation_commentService {
    @Autowired
    private Tb_commentMapper tb_commentMapper;
    @RequestMapping("/getTb_commentPage")
    public PageUtil getTb_commentPage(@RequestParam Map<String,Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = tb_commentMapper.getCount(map);
        page.setTotalCount(count);
        //调用mapper方法
        List<Invitation_comment> list = tb_commentMapper.getTb_commentPage(map);
        page.setList(list);
        return page;
    }

    //添加新的帖子评论
    @RequestMapping("/addTb_comment")
    public int addTb_comment(@RequestBody Invitation_comment comment){
        return tb_commentMapper.addTb_comment(comment);
    }

    //更新帖子评论信息
    @RequestMapping("/updateTb_comment")
    public int updateTb_comment(@RequestBody Invitation_comment comment){
        return tb_commentMapper.updateTb_comment(comment);
    }

    //根据帖子ID更新帖子评论的点赞数
    @RequestMapping("/updateCnum/{id}")
    public int updateCnum(@PathVariable("id") Integer id){
        return tb_commentMapper.updateCnum(id);
    }

    //根据ID删除某个帖子评论
    @RequestMapping("/deleteTb_comment/{id}")
    public int deleteTb_comment(@PathVariable("id") Integer id){
        return tb_commentMapper.deleteTb_comment(id);
    }
}
