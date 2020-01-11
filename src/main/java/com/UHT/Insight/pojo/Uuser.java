package com.UHT.Insight.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Uuser {
    private Integer UU_ID;
    private String UU_NAME;
    private String UU_PHONE;
    private String PASSWORD;
    private Boolean SEX;
    private String COMPANY;
    private String P_COMMENT;
    private Date BIRTHDAY;
    private int AGE;

}
