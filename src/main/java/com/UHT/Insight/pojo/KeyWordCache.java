package com.UHT.Insight.pojo;

import java.io.Serializable;
import java.util.Date;

public class KeyWordCache implements Serializable {
    private Integer K_ID;       //关键词id
    private byte[] keyWordCache;
    private Date createTime;
    public Integer getK_ID() {
        return K_ID;
    }

    public void setK_ID(Integer k_ID) {
        K_ID = k_ID;
    }

    public byte[] getKeyWordCache() {
        return keyWordCache;
    }

    public void setKeyWordCache(byte[] keyWordCache) {
        this.keyWordCache = keyWordCache;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public KeyWordCache() {
    }

    public KeyWordCache(Integer k_ID, byte[] keyWordCache, Date createTime) {
        K_ID = k_ID;
        this.keyWordCache = keyWordCache;
        this.createTime = createTime;
    }
}
