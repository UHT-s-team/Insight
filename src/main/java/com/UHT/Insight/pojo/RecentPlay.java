package com.UHT.Insight.pojo;

import java.io.Serializable;
import java.util.Date;

public class RecentPlay implements Serializable {
    private Integer R_ID;//关联Id
    private Integer G_ID;//游戏Id
    private Integer U_ID;//用户id
    private String G_TIME;

    public Integer getR_ID() {
        return R_ID;
    }

    public void setR_ID(Integer r_ID) {
        R_ID = r_ID;
    }

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

    public String getG_TIME() {
        return G_TIME;
    }

    public void setG_TIME(String g_TIME) {
        G_TIME = g_TIME;
    }

    @Override
    public String toString() {
        return "RecentPlay{" +
                "R_ID=" + R_ID +
                ", G_ID=" + G_ID +
                ", U_ID=" + U_ID +
                ", G_TIME='" + G_TIME + '\'' +
                '}';
    }

    public RecentPlay(Integer r_ID, Integer g_ID, Integer u_ID, String g_TIME) {
        R_ID = r_ID;
        G_ID = g_ID;
        U_ID = u_ID;
        G_TIME = g_TIME;
    }

    public RecentPlay() {
    }
}
