package com.UHT.Insight.pojo;

import java.io.Serializable;
/*
 *对应game表（TapTap游戏信息表）
 *
 */
public class Game implements Serializable {
    private Integer G_ID;       //游戏id
    private String G_NAME;      //游戏名称
    private String BREIF;       //简介
    private String R_CONTENT;   //最近更新内容
    private Integer R_NUMBER;   //评论数量
    private Integer C_NUMBER;   //社区数量
    private String VENDER;      //厂商
    private Float A_DRADE;      //总评分
    private String T_TAGLTB;    //类型标签
    private String RECOMMENT;  //是否推荐，
    private Integer DOWNLOAD;   //下载次数
    private Integer ATTENTION;  //关注数
    private String URL;         //图片路径
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

    public String getBREIF() {
        return BREIF;
    }

    public void setBREIF(String BREIF) {
        this.BREIF = BREIF;
    }

    public String getR_CONTENT() {
        return R_CONTENT;
    }

    public void setR_CONTENT(String r_CONTENT) {
        R_CONTENT = r_CONTENT;
    }

    public Integer getR_NUMBER() {
        return R_NUMBER;
    }

    public void setR_NUMBER(Integer r_NUMBER) {
        R_NUMBER = r_NUMBER;
    }

    public Integer getC_NUMBER() {
        return C_NUMBER;
    }

    public void setC_NUMBER(Integer c_NUMBER) {
        C_NUMBER = c_NUMBER;
    }

    public String getVENDER() {
        return VENDER;
    }

    public void setVENDER(String VENDER) {
        this.VENDER = VENDER;
    }

    public Float getA_DRADE() {
        return A_DRADE;
    }

    public void setA_DRADE(Float a_DRADE) {
        A_DRADE = a_DRADE;
    }

    public String getT_TAGLTB() {
        return T_TAGLTB;
    }

    public void setT_TAGLTB(String t_TAGLTB) {
        T_TAGLTB = t_TAGLTB;
    }

    public String getRECOMMENT() {
        return RECOMMENT;
    }

    public void setRECOMMENT(String RECOMMENT) {
        this.RECOMMENT = RECOMMENT;
    }

    public Integer getDOWNLOAD() {
        return DOWNLOAD;
    }

    public void setDOWNLOAD(Integer DOWNLOAD) {
        this.DOWNLOAD = DOWNLOAD;
    }

    public Integer getATTENTION() {
        return ATTENTION;
    }

    public void setATTENTION(Integer ATTENTION) {
        this.ATTENTION = ATTENTION;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    //构造函数
    public Game(){};
    //带参数的构造函数

    public Game(String g_NAME, String VENDER, String t_TAGLTB) {
        G_NAME = g_NAME;
        this.VENDER = VENDER;
        T_TAGLTB = t_TAGLTB;
    }

    public Game(Integer g_ID, String g_NAME, String BREIF, String r_CONTENT, Integer r_NUMBER, Integer c_NUMBER, String VENDER, Float a_DRADE, String t_TAGLTB, String RECOMMENT, Integer DOWNLOAD, Integer ATTENTION, String URL) {
        G_ID = g_ID;
        G_NAME = g_NAME;
        this.BREIF = BREIF;
        R_CONTENT = r_CONTENT;
        R_NUMBER = r_NUMBER;
        C_NUMBER = c_NUMBER;
        this.VENDER = VENDER;
        A_DRADE = a_DRADE;
        T_TAGLTB = t_TAGLTB;
        this.RECOMMENT = RECOMMENT;
        this.DOWNLOAD = DOWNLOAD;
        this.ATTENTION = ATTENTION;
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Game{" +
                "G_ID=" + G_ID +
                ", G_NAME='" + G_NAME + '\'' +
                ", BREIF='" + BREIF + '\'' +
                ", R_CONTENT='" + R_CONTENT + '\'' +
                ", R_NUMBER=" + R_NUMBER +
                ", C_NUMBER=" + C_NUMBER +
                ", VENDER='" + VENDER + '\'' +
                ", A_DRADE=" + A_DRADE +
                ", T_TAGLTB='" + T_TAGLTB + '\'' +
                ", RECOMMENT=" + RECOMMENT +
                ", DOWNLOAD=" + DOWNLOAD +
                ", ATTENTION=" + ATTENTION +
                ", URL='" + URL + '\'' +
                '}';
    }
}
