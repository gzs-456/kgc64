package com.kgc.vo;

import java.io.Serializable;

public class InvitationVo  implements Serializable {
    private String id;//id
    private String title;//标题
    private Integer oldCount;//原始点赞数
    private Integer currentCount;//更改过的点赞数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOldCount() {
        return oldCount;
    }

    public void setOldCount(Integer oldCount) {
        this.oldCount = oldCount;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }
}
