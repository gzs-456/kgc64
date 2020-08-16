package com.kgc.service;

import com.kgc.mapper.Column_columnMapper;
import com.kgc.pojo.Column_channel;
import com.kgc.pojo.Column_column;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Column_columnService {

    @Autowired
    private Column_columnMapper columnMapper;

    /*
       分页，根据专栏名称，申请时间查询所有专栏
       并根据申请时间降序排列
    */
    @RequestMapping("/getAllColumn_column")
    public PageUtil getAllColumn_column(@RequestParam Map<String, Object> map){
        PageUtil page=new PageUtil();
        //当前页面
        Integer pageIndex=Integer.parseInt(map.get("pageIndex").toString());
        page.setPageIndex(pageIndex);
        //每页条数
        Integer pageSize=Integer.parseInt(map.get("pageSize").toString());
        page.setPageSize(pageSize);
        int count = columnMapper.getCount(map);
        page.setTotalCount(count);
        //调用mapper方法
        List<Column_column> list = columnMapper.getAllColumn_column(map);
        page.setList(list);
        return page;
    }

    //根据专栏编号查询该专栏信息
    @RequestMapping("/Column_column/{id}")
    public Column_column getColumnById(@PathVariable("id") Integer id){
        return columnMapper.getColumnById(id);
    }

    //添加专栏
    @RequestMapping("/addColumn")
    public int addColumn(@RequestBody Column_column column){
        return columnMapper.addColumn(column);
    }

    //更新专栏信息
    @RequestMapping("/updateColumn")
    public int updateColumn(@RequestBody Column_column column){
        return columnMapper.updateColumn(column);
    }

    //根据专栏编号删除专栏
    @RequestMapping("/deleteColumn/{id}")
    public int deleteColumn(@PathVariable("id") Integer id){
        return columnMapper.deleteColumn(id);
    }
}
