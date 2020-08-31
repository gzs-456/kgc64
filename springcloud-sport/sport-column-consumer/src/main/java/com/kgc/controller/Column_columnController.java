package com.kgc.controller;

import com.kgc.pojo.Column_column;
import com.kgc.service.Column_columnService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class Column_columnController {
    @Autowired
    private Column_columnService columnService;

    /*
      分页，根据专栏名称，申请时间查询所有专栏
      并根据申请时间降序排列
   */
    @RequestMapping("/getAllColumn_column")
    public PageUtil getAllColumn_column(String cname,String createtime,
                                        @RequestParam(value = "pageIndex", defaultValue = "1")Integer pageIndex,
                                        @RequestParam(value = "pageSize", defaultValue = "2")Integer pageSize){
        return columnService.getAllColumn_column(cname,createtime,pageIndex,pageSize);
    }

    //根据专栏编号查询该专栏信息
    @RequestMapping("/getColumnById")
    public Column_column getColumnById(Integer id){
        return columnService.getColumnById(id);
    }

    //添加专栏
    @RequestMapping("/addColumn")
    public int addColumn( Column_column column){
        return columnService.addColumn(column);
    }

    //更新专栏信息
    @RequestMapping("/updateColumn")
    public int updateColumn( Column_column column){
        return columnService.updateColumn(column);
    }

    //根据专栏编号删除专栏
    @RequestMapping("/deleteColumn")
    public int deleteColumn(Integer id){
        return columnService.deleteColumn(id);
    }
}
