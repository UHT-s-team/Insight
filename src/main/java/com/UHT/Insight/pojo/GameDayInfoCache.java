package com.UHT.Insight.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class GameDayInfoCache implements Serializable {
    private Integer G_ID;       //游戏id
    private byte[] InfoCache;
    private Date createTime;
    public Integer getG_ID() {
        return G_ID;
    }

    public void setG_ID(Integer g_ID) {
        G_ID = g_ID;
    }

    public byte[] getInfoCache() {
        return InfoCache;
    }

    public void setInfoCache(byte[] infoCache) {
        InfoCache = infoCache;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public GameDayInfoCache() {}

    public GameDayInfoCache(Integer g_ID, byte[] infoCache, Date createTime) {
        G_ID = g_ID;
        InfoCache = infoCache;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GameDayInfoCache{" +
                "G_ID=" + G_ID +
                ", InfoCache=" + Arrays.toString(InfoCache) +
                ", createTime=" + createTime +
                '}';
    }
}
