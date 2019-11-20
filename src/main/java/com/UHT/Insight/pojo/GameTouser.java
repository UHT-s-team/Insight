package com.UHT.Insight.pojo;

import java.io.Serializable;
import java.util.Date;
/*
 *对应gameToUser表（TapTap游戏评论对应用户信息表）
 *
 */
public class GameTouser implements Serializable {
     private Integer D_ID;        //评论id
     private Integer U_ID;        //TapTap用户ID
     private Integer G_ID;        //对应游戏ID
     private String U_NAME;       //用户名称
     private Date I_TIME;         //发布时间
     private Float D_START;       //评分星级
     private String G_TIME;        //游戏时长
     private String D_CONTENT;    //评论内容
     private String G_EQUTPTMENT; //游戏设备
     private Integer D_HAPPY;     //欢乐数
     private Integer D_AGRESS;    //点赞数
     private Integer D_DISAGRESS; //点踩数
     private Integer REPLY;       //回复数

    public Integer getD_ID() {
        return D_ID;
    }

    public void setD_ID(Integer d_ID) {
        D_ID = d_ID;
    }

    public Integer getU_ID() {
        return U_ID;
    }

    public void setU_ID(Integer u_ID) {
        U_ID = u_ID;
    }

    public Integer getG_ID() {
        return G_ID;
    }

    public void setG_ID(Integer g_ID) {
        G_ID = g_ID;
    }

    public String getU_NAME() {
        return U_NAME;
    }

    public void setU_NAME(String u_NAME) {
        U_NAME = u_NAME;
    }

    public Date getI_TIME() {
        return this.I_TIME;
    }

    public void setI_TIME(Date I_TIME) {
        this.I_TIME = I_TIME;
    }

    public Float getD_START() {
        return D_START;
    }

    public void setD_START(Float d_START) {
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
     //构造方法
    public GameTouser() { }
    public GameTouser(Integer d_ID, Integer u_ID, Integer g_ID, String u_NAME, Date i_TIME, Float d_START,String g_TIME, String d_CONTENT, String g_EQUTPTMENT, Integer d_HAPPY, Integer d_AGRESS, Integer d_DISAGRESS, Integer REPLY) {
        D_ID = d_ID;
        U_ID = u_ID;
        G_ID = g_ID;
        U_NAME = u_NAME;
        I_TIME = i_TIME;
        D_START = d_START;
        G_TIME = g_TIME;
        D_CONTENT = d_CONTENT;
        G_EQUTPTMENT = g_EQUTPTMENT;
        D_HAPPY = d_HAPPY;
        D_AGRESS = d_AGRESS;
        D_DISAGRESS = d_DISAGRESS;
        this.REPLY = REPLY;
    }

    @Override
    public String toString() {
        return "GameTouser{" +
                "D_ID=" + D_ID +
                ", U_ID=" + U_ID +
                ", G_ID=" + G_ID +
                ", U_NAME='" + U_NAME + '\'' +
                ", I_TIME=" + I_TIME +
                ", D_START=" + D_START +
                ", G_TIME=" + G_TIME +
                ", D_CONTENT='" + D_CONTENT + '\'' +
                ", G_EQUTPTMENT='" + G_EQUTPTMENT + '\'' +
                ", D_HAPPY=" + D_HAPPY +
                ", D_AGRESS=" + D_AGRESS +
                ", D_DISAGRESS=" + D_DISAGRESS +
                ", REPLY=" + REPLY +
                '}';
    }
}
