package com.kgc.client.impl;

import com.kgc.client.Column_articleClient;
import com.kgc.pojo.Column_article;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class Column_articleClientImpl implements Column_articleClient {
    @Override
    public PageUtil getArticlePage(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Column_article> getAllarticleByalid(Integer alid) {
        return null;
    }

    @Override
    public List<Column_article> getAllarticleBycolumnid(Integer columnid, String atype) {
        return null;
    }

    @Override
    public Column_article getarticleById(Integer id) {
        return null;
    }

    @Override
    public int addArticle(Column_article article) {
        return 0;
    }

    @Override
    public int updateArticle(Column_article article) {
        return 0;
    }

    @Override
    public int updateVisits(Integer id) {
        return 0;
    }

    @Override
    public int updateThumbup(Integer id) {
        return 0;
    }

    @Override
    public int updateAcomment(Integer id) {
        return 0;
    }

    @Override
    public int deleteArticle(Integer id) {
        return 0;
    }
}
