package com.kgc.client;

import com.kgc.client.impl.Column_columnClientImpl;
import com.kgc.pojo.Column_column;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "sport-column-provider",fallback = Column_columnClientImpl.class)
public interface Column_columnClient {
    /*
       分页，根据专栏名称，申请时间查询所有专栏
       并根据申请时间降序排列
    */
    @RequestMapping("/getAllColumn_column")
    public PageUtil getAllColumn_column(@RequestParam Map<String, Object> map);

    //根据专栏编号查询该专栏信息
    @RequestMapping("/getColumnById/{id}")
    public Column_column getColumnById(@PathVariable("id") Integer id);

    //添加专栏
    @RequestMapping("/addColumn")
    public int addColumn(@RequestBody Column_column column);

    //更新专栏信息
    @RequestMapping("/updateColumn")
    public int updateColumn(@RequestBody Column_column column);

    //根据专栏编号删除专栏
    @RequestMapping("/deleteColumn/{id}")
    public int deleteColumn(@PathVariable("id") Integer id);
}
