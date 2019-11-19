package com.UHT.Insight.pojo;

import java.io.Serializable;
/*
*对应本系统用户信息表UUser
 */
public class Uuser implements Serializable {
    private Integer UU_ID;         //用户Id
    private String UU_NAME;        //用户名称
    private String UU_PHONE;       //用户电话
    private String PASSWORD;       //密码
    private Integer SEX;            //性别
    private String COMPANY;         //所属公司
    private String P_COMMENT;       //个性评价

    public Integer getUU_ID() {
        return UU_ID;
    }

    public void setUU_ID(Integer UU_ID) {
        this.UU_ID = UU_ID;
    }

    public String getUU_NAME() {
        return UU_NAME;
    }

    public void setUU_NAME(String UU_NAME) {
        this.UU_NAME = UU_NAME;
    }

    public String getUU_PHONE() {
        return UU_PHONE;
    }

    public void setUU_PHONE(String UU_PHONE) {
        this.UU_PHONE = UU_PHONE;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Integer getSEX() {
        return SEX;
    }

    public void setSEX(Integer SEX) {
        this.SEX = SEX;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY) {
        this.COMPANY = COMPANY;
    }

    public String getP_COMMENT() {
        return P_COMMENT;
    }

    public void setP_COMMENT(String p_COMMENT) {
        P_COMMENT = p_COMMENT;
    }
    //构造函数
    public Uuser(){}

    public Uuser(Integer UU_ID, String UU_NAME, String UU_PHONE, String PASSWORD, Integer SEX, String COMPANY, String p_COMMENT) {
        this.UU_ID = UU_ID;
        this.UU_NAME = UU_NAME;
        this.UU_PHONE = UU_PHONE;
        this.PASSWORD = PASSWORD;
        this.SEX = SEX;
        this.COMPANY = COMPANY;
        P_COMMENT = p_COMMENT;
    }

    @Override
    public String toString() {
        return "Uuser{" +
                "UU_ID=" + UU_ID +
                ", UU_NAME='" + UU_NAME + '\'' +
                ", UU_PHONE='" + UU_PHONE + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", SEX=" + SEX +
                ", COMPANY='" + COMPANY + '\'' +
                ", P_COMMENT='" + P_COMMENT + '\'' +
                '}';
    }
}
