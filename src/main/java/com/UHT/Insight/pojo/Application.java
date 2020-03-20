package com.UHT.Insight.pojo;


import java.io.Serializable;
/*
 *对应application表（应用分日信息表）
 *
 */


public class Application implements Serializable {
    private Integer G_ID;   //应用id
    private Float S_GRADE; //统计时评分
    private Integer N_NUM_GRADE;  //新增评分数量
    private String VERSION;  //应用版本
    private String KEYWORD; //关键词
    private String EVENT;   //事件


    public Integer getG_ID() {
        return G_ID;
    }

    public void setG_ID(Integer g_ID) {
        G_ID = g_ID;
    }

    public Float getS_GRADE() {
        return S_GRADE;
    }

    public void setS_GRADE(Float s_GRADE) {
        S_GRADE = s_GRADE;
    }

    public Integer getN_NUM_GRADE() {
        return N_NUM_GRADE;
    }

    public void setN_NUM_GRADE(Integer n_NUM_GRADE) {
        N_NUM_GRADE = n_NUM_GRADE;
    }

    public String getVERSION() {
        return VERSION;
    }

    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }

    public String getKEYWORD() {
        return KEYWORD;
    }

    public void setKEYWORD(String KEYWORD) {
        this.KEYWORD = KEYWORD;
    }

    public String getEVENT() {
        return EVENT;
    }

    public void setEVENT(String EVENT) {
        this.EVENT = EVENT;
    }
    //构造方法
    public Application() { }

    public Application(Integer g_ID, Float s_GRADE, Integer n_NUM_GRADE, String VERSION, String KEYWORD, String EVENT) {
        G_ID = g_ID;
        S_GRADE = s_GRADE;
        N_NUM_GRADE = n_NUM_GRADE;
        this.VERSION = VERSION;
        this.KEYWORD = KEYWORD;
        this.EVENT = EVENT;
    }
    @Override
    public String toString() {
        return "Application{" +
                "G_ID=" + G_ID +
                ", S_GRADE='" + S_GRADE + '\'' +
                ", N_NUM=" + N_NUM_GRADE +
                ", VESION='" + VERSION + '\'' +
                ", KEYWORD='" + KEYWORD + '\'' +
                ", EVENT='" + EVENT + '\'' +
                '}';
    }
}
