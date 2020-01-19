package com.UHT.Insight.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

@Data
public class GameDayKeywordDTO implements Serializable {
    private Date time;         //发布时间
    private Integer num;      //发布条数
    private Float average;    //平均评分
    private HashMap<String,Integer> keywordMap;//当天的关键字

}
