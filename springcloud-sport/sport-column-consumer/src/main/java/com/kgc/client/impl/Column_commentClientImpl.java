package com.kgc.client.impl;

import com.kgc.client.Column_commentClient;
import com.kgc.pojo.Column_comment;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class Column_commentClientImpl implements Column_commentClient {
    @Override
    public PageUtil getAllComment(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Column_comment> getCommentById(Integer articleid, String atype) {
        return null;
    }

    @Override
    public int addComment(Column_comment comment) {
        return 0;
    }

    @Override
    public int updateComment(Column_comment comment) {
        return 0;
    }

    @Override
    public int deleteComment(Integer id) {
        return 0;
    }
}
