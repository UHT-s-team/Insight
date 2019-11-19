package com.UHT.Insight.pojo;

import java.io.Serializable;

public class RecentPlay implements Serializable {
    private Integer G_ID;//游戏Id
    private Integer U_ID;//用户id
    private String G_NAME;//游戏名称
    private String G_TIME;//游戏时长
    private String T_TAGLIB;//游戏标签

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

    public String getG_NAME() {
        return G_NAME;
    }

    public void setG_NAME(String g_NAME) {
        G_NAME = g_NAME;
    }

    public String getG_TIME() {
        return G_TIME;
    }

    public void setG_TIME(String g_TIME) {
        G_TIME = g_TIME;
    }

    public String getT_TAGLIB() {
        return T_TAGLIB;
    }

    public void setT_TAGLIB(String t_TAGLIB) {
        T_TAGLIB = t_TAGLIB;
    }

    public RecentPlay() { }

    public RecentPlay(Integer g_ID, Integer u_ID, String g_NAME, String g_TIME, String t_TAGLIB) {
        G_ID = g_ID;
        U_ID = u_ID;
        G_NAME = g_NAME;
        G_TIME = g_TIME;
        T_TAGLIB = t_TAGLIB;
    }

    @Override
    public String toString() {
        return "RecentPlay{" +
                "G_ID=" + G_ID +
                ", U_ID=" + U_ID +
                ", G_NAME='" + G_NAME + '\'' +
                ", G_TIME='" + G_TIME + '\'' +
                ", T_TAGLIB='" + T_TAGLIB + '\'' +
                '}';
    }
}
