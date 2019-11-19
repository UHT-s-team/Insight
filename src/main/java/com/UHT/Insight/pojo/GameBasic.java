package com.UHT.Insight.pojo;

import java.io.Serializable;
/*
*对应游戏基本信息表gameBasic
 */
public class GameBasic implements Serializable {
    private Integer G_ID;         //应用ID
    private String G_NAME;        //应用名称
    private Float N_GRADE;       //最新评分
    private Float R_G_WEIGHT;    //权重调整后评分
    private Float L_GRADE;       //长评评分

    public Integer getG_ID() {
        return G_ID;
    }

    public void setG_ID(Integer g_ID) {
        G_ID = g_ID;
    }

    public String getG_NAME() {
        return G_NAME;
    }

    public void setG_NAME(String g_NAME) {
        G_NAME = g_NAME;
    }

    public Float getN_GRADE() {
        return N_GRADE;
    }

    public void setN_GRADE(Float n_GRADE) {
        N_GRADE = n_GRADE;
    }

    public Float getR_G_WEIGHT() {
        return R_G_WEIGHT;
    }

    public void setR_G_WEIGHT(Float r_G_WEIGHT) {
        R_G_WEIGHT = r_G_WEIGHT;
    }

    public Float getL_GRADE() {
        return L_GRADE;
    }

    public void setL_GRADE(Float l_GRADE) {
        L_GRADE = l_GRADE;
    }

    //构造方法
    public GameBasic(){}

    public GameBasic(Integer g_ID, String g_NAME, Float n_GRADE, Float r_G_WEIGHT, Float l_GRADE) {
        G_ID = g_ID;
        G_NAME = g_NAME;
        N_GRADE = n_GRADE;
        R_G_WEIGHT = r_G_WEIGHT;
        L_GRADE = l_GRADE;
    }

    @Override
    public String toString() {
        return "GameBasic{" +
                "G_ID=" + G_ID +
                ", G_NAME='" + G_NAME + '\'' +
                ", N_GRADE=" + N_GRADE +
                ", R_G_WEIGHT=" + R_G_WEIGHT +
                ", L_GRADE=" + L_GRADE +
                '}';
    }
}
