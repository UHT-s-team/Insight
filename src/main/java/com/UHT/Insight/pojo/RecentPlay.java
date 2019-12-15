package com.UHT.Insight.pojo;

import java.io.Serializable;
import java.util.Date;

public class RecentPlay implements Serializable {
    private Integer R_ID;//关联Id
    private Integer G_ID;//游戏Id
    private Integer U_ID;//用户id
    private Date G_TIME;

    public Integer getG_ID() {
        return G_ID;
    }

    public void setG_ID(Integer g_ID) {
        G_ID = g_ID;
    }

    public Integer getU_ID() {
        return U_ID;
    }

    public void setU_ID(Integer u_ID) {
        U_ID = u_ID;
    }

    public Integer getR_ID() {
        return R_ID;
    }

    public void setR_ID(Integer r_ID) {
        R_ID = r_ID;
    }

    public Date getG_TIME() {
        return G_TIME;
    }

    public void setG_TIME(Date g_TIME) {
        G_TIME = g_TIME;
    }

    public RecentPlay() {
    }

    public RecentPlay(Integer r_ID, Integer g_ID, Integer u_ID,Date g_TIME) {
        R_ID = r_ID;
        G_ID = g_ID;
        U_ID = u_ID;
        G_TIME = g_TIME;
    }
}
