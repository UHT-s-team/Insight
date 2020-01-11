package com.UHT.Insight.pojo;

import java.util.Date;

public class TapUserAndGameToUser {
    private Integer U_ID;         //用户Id
    private String U_NAME;        //当前用户名
    private Integer FANS;       //粉丝数
    private Integer ATTENTION;     //关注数
    private Integer COLLECT;      //收藏数
    private Integer PLAY;    //玩过游戏数
    private Integer L_PLAY;      //玩得最久游戏数
    private Integer APPRAISE;         //评价数
    private  Float G_WEIGHT;       //评分权重
    private Integer D_ID;        //评论id
    private Integer G_ID;        //对应游戏ID
    private Date I_TIME;         //发布时间
    private Integer D_START;       //评分星级
    private String G_TIME;        //游戏时长
    private String D_CONTENT;    //评论内容
    private String G_EQUTPTMENT; //游戏设备
    private Integer D_HAPPY;     //欢乐数
    private Integer D_AGRESS;    //点赞数
    private Integer D_DISAGRESS; //点踩数
    private Integer REPLY;       //回复数


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

    public Integer getD_ID() {
        return D_ID;
    }

    public void setD_ID(Integer d_ID) {
        D_ID = d_ID;
    }

    public Integer getG_ID() {
        return G_ID;
    }

    public void setG_ID(Integer g_ID) {
        G_ID = g_ID;
    }

    public Date getI_TIME() {
        return I_TIME;
    }

    public void setI_TIME(Date i_TIME) {
        I_TIME = i_TIME;
    }

    public Integer getD_START() {
        return D_START;
    }

    public void setD_START(Integer d_START) {
        D_START = d_START;
    }

    public String getG_TIME() {
        return G_TIME;
    }

    public void setG_TIME(String g_TIME) {
        G_TIME = g_TIME;
    }

    public String getD_CONTENT() {
        return D_CONTENT;
    }

    public void setD_CONTENT(String d_CONTENT) {
        D_CONTENT = d_CONTENT;
    }

    public String getG_EQUTPTMENT() {
        return G_EQUTPTMENT;
    }

    public void setG_EQUTPTMENT(String g_EQUTPTMENT) {
        G_EQUTPTMENT = g_EQUTPTMENT;
    }

    public Integer getD_HAPPY() {
        return D_HAPPY;
    }

    public void setD_HAPPY(Integer d_HAPPY) {
        D_HAPPY = d_HAPPY;
    }

    public Integer getD_AGRESS() {
        return D_AGRESS;
    }

    public void setD_AGRESS(Integer d_AGRESS) {
        D_AGRESS = d_AGRESS;
    }

    public Integer getD_DISAGRESS() {
        return D_DISAGRESS;
    }

    public void setD_DISAGRESS(Integer d_DISAGRESS) {
        D_DISAGRESS = d_DISAGRESS;
    }

    public Integer getREPLY() {
        return REPLY;
    }

    public void setREPLY(Integer REPLY) {
        this.REPLY = REPLY;
    }
}
