package com.UHT.Insight.pojo;

import java.io.Serializable;
/*
*对应Taptap论坛用户基本信息表
 */
public class TapUser implements Serializable {
    private Integer U_ID;         //用户Id
    private String U_NAME;        //当前用户名
    private Integer FANS;       //粉丝数
    private Integer ATTENTION;     //关注数
    private Integer COLLECT;      //收藏数
    private Integer PLAY;    //玩过游戏数
    private Integer L_PLAY;      //玩得最久游戏数
    private Integer APPRAISE;         //评价数
    private  Float G_WEIGHT;       //评分权重

    public Integer getU_ID() {
        return U_ID;
    }

    public void setU_ID(Integer u_ID) {
        U_ID = u_ID;
    }

    public String getU_NAME() {
        return U_NAME;
    }

    public void setU_NAME(String u_NAME) {
        U_NAME = u_NAME;
    }

    public Integer getFANS() {
        return FANS;
    }

    public void setFANS(Integer FANS) {
        this.FANS = FANS;
    }

    public Integer getATTENTION() {
        return ATTENTION;
    }

    public void setATTENTION(Integer ATTENTION) {
        this.ATTENTION = ATTENTION;
    }

    public Integer getCOLLECT() {
        return COLLECT;
    }

    public void setCOLLECT(Integer COLLECT) {
        this.COLLECT = COLLECT;
    }

    public Integer getPLAY() {
        return PLAY;
    }

    public void setPLAY(Integer PLAY) {
        this.PLAY = PLAY;
    }

    public Integer getL_PLAY() {
        return L_PLAY;
    }

    public void setL_PLAY(Integer l_PLAY) {
        L_PLAY = l_PLAY;
    }

    public Integer getAPPRAISE() {
        return APPRAISE;
    }

    public void setAPPRAISE(Integer APPRAISE) {
        this.APPRAISE = APPRAISE;
    }

    public Float getG_WEIGHT() {
        return G_WEIGHT;
    }

    public void setG_WEIGHT(Float g_WEIGHT) {
        G_WEIGHT = g_WEIGHT;
    }

    public TapUser() { }

    public TapUser(Integer u_ID, String u_NAME, Integer FANS, Integer ATTENTION, Integer COLLECT, Integer PLAY, Integer l_PLAY,Integer APPRAISE, Float g_WEIGHT) {
        U_ID = u_ID;
        U_NAME = u_NAME;
        this.FANS = FANS;
        this.ATTENTION = ATTENTION;
        this.COLLECT = COLLECT;
        this.PLAY = PLAY;
        L_PLAY = l_PLAY;
        this.APPRAISE = APPRAISE;
        G_WEIGHT = g_WEIGHT;
    }

    @Override
    public java.lang.String toString() {
        return "TapUser{" +
                "U_ID=" + U_ID +
                ", U_NAME='" + U_NAME + '\'' +
                ", FANS=" + FANS +
                ", ATTENTION=" + ATTENTION +
                ", COLLECT=" + COLLECT +
                ", PLAY=" + PLAY +
                ", L_PLAY=" + L_PLAY +
                ", APPRAISE='" + APPRAISE + '\'' +
                ", G_WEIGHT=" + G_WEIGHT +
                '}';
    }
}
