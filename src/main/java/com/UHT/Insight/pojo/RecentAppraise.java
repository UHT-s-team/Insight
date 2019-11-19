package com.UHT.Insight.pojo;


import java.io.Serializable;
import java.util.Date;

public class RecentAppraise implements Serializable {
        private Integer R_ID;     //评论ID
        private Integer U_ID;     //用户ID
        private String G_TIME;    //游戏时长
        private Date R_DATE;       //评价日期
        private float R_STAR;       //评价星级
        private  Integer R_LONG;    //评价长度

    public Integer getR_ID() {
        return R_ID;
    }

    public void setR_ID(Integer r_ID) {
        R_ID = r_ID;
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

    public Date getR_DATE() {
        return R_DATE;
    }

    public void setR_DATE(Date r_DATE) {
        R_DATE = r_DATE;
    }

    public float getR_STAR() {
        return R_STAR;
    }

    public void setR_STAR(float r_STAR) {
        R_STAR = r_STAR;
    }

    public Integer getR_LONG() {
        return R_LONG;
    }

    public void setR_LONG(Integer r_LONG) {
        R_LONG = r_LONG;
    }

    public RecentAppraise() { }

    public RecentAppraise(Integer r_ID, Integer u_ID, String g_TIME, Date r_DATE, float r_STAR, Integer r_LONG) {
        R_ID = r_ID;
        U_ID = u_ID;
        G_TIME = g_TIME;
        R_DATE = r_DATE;
        R_STAR = r_STAR;
        R_LONG = r_LONG;
    }

    @Override
    public String toString() {
        return "RecentAppraise{" +
                "R_ID=" + R_ID +
                ", U_ID=" + U_ID +
                ", G_TIME='" + G_TIME + '\'' +
                ", R_DATE=" + R_DATE +
                ", R_STAR=" + R_STAR +
                ", R_LONG=" + R_LONG +
                '}';
    }
}
