package com.kgc.controller;

import com.kgc.pojo.Column_al;
import com.kgc.service.Column_alService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Column_alController {
    @Autowired
    private Column_alService alService;
    //查询所有的标签
    @RequestMapping("/getAllColumn_al")
    public List<Column_al> getAllColumn_al(){
        return alService.getAllColumn_al();
    }

    //添加标签
    @RequestMapping("/addColumn_al")
    public int addColumn_al( Column_al al){
        return alService.addColumn_al(al);
    }

    //根据标签编号更新标签名
    @RequestMapping("/updateColumn_al")
    public int updateColumn_al( Column_al al){
        return alService.updateColumn_al(al);
    }

    //根据标签编号删除标签
    @RequestMapping("/deleteColumn_al")
    public int deleteColumn_al(Integer id){
        return alService.deleteColumn_al(id);
    }
}
