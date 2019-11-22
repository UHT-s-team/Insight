package com.UHT.Insight.pojo;

import java.util.Date;
/*
*对查询返回的I_TIME,count(0),avg的数据进行封装
* 对应数据发布时间，发布条数，平均评分
 */
public class GameEverydayData {
    private Date time;         //发布时间
    private Integer num;      //发布条数
    private Float average;    //平均评分

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "GameEverydayData{" +
                "time=" + time +
                ", num=" + num +
                ", average=" + average +
                '}';
    }
}
