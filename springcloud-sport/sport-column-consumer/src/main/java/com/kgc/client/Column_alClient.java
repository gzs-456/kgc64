package com.kgc.client;

import com.kgc.client.impl.Column_alClientImpl;
import com.kgc.pojo.Column_al;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "sport-column-provider",fallback = Column_alClientImpl.class)
public interface Column_alClient {
    //查询所有的标签
    @RequestMapping("/getAllColumn_al")
    public List<Column_al> getAllColumn_al();

    //添加标签
    @RequestMapping("/addColumn_al")
    public int addColumn_al(@RequestBody Column_al al);

    //根据标签编号更新标签名
    @RequestMapping("/updateColumn_al")
    public int updateColumn_al(@RequestBody Column_al al);

    //根据标签编号删除标签
    @RequestMapping("/deleteColumn_al/{id}")
    public int deleteColumn_al(@PathVariable("id") Integer id);
}
