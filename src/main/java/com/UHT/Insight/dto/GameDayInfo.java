package com.UHT.Insight.dto;

import java.io.Serializable;
import java.util.Date;

public class GameDayInfo implements Serializable {
    private Date time;         //发布时间
    private Integer num;      //发布条数
    private Float average;    //平均评分

    private Integer OneStarNum;
    private Integer TowStarNum;
    private Integer ThreeStarNum;
    private Integer FourStarNum;
    private Integer FiveStarNum;
    //一到五星评分数量


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

    public Integer getOneStarNum() {
        return OneStarNum;
    }

    public void setOneStarNum(Integer oneStarNum) {
        OneStarNum = oneStarNum;
    }

    public Integer getTowStarNum() {
        return TowStarNum;
    }

    public void setTwoStarNum(Integer towStarNum) {
        TowStarNum = towStarNum;
    }

    public Integer getThreeStarNum() {
        return ThreeStarNum;
    }

    public void setThreeStarNum(Integer threeStarNum) {
        ThreeStarNum = threeStarNum;
    }

    public Integer getFourStarNum() {
        return FourStarNum;
    }

    public void setFourStarNum(Integer fourStarNum) {
        FourStarNum = fourStarNum;
    }

    public Integer getFiveStarNum() {
        return FiveStarNum;
    }

    public void setFiveStarNum(Integer fiveStarNum) {
        FiveStarNum = fiveStarNum;
    }
}
