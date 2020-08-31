package com.kgc.service;

import com.kgc.mapper.Column_alMapper;
import com.kgc.pojo.Column_al;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestColumn_alService {
    @Autowired
    private Column_alMapper alMapper;

    //查询所有的标签
    @RequestMapping("/getAllColumn_al")
    public List<Column_al>getAllColumn_al(){
        return alMapper.getAllColumn_al();
    }

    //添加标签
    @RequestMapping("/addColumn_al")
    public int addColumn_al(@RequestBody Column_al al){
        return alMapper.addColumn_al(al);
    }

    //根据标签编号更新标签名
    @RequestMapping("/updateColumn_al")
    public int updateColumn_al(@RequestBody Column_al al){
        return alMapper.updateColumn_al(al);
    }

    //根据标签编号删除标签
    @RequestMapping("/deleteColumn_al/{id}")
    public int deleteColumn_al(@PathVariable("id") Integer id){
        return alMapper.deleteColumn_al(id);
    }
}
