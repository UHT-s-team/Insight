package com.UHT.Insight.pojo;

import java.util.Date;
//保存每天的各级星级数量
public class GameStarLevel {
    private Date time;         //发布时间
    private Integer num;      //星级数量
    private Float star;     //评分星级

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

    public Float getStar() {
        return star;
    }

    public void setStar(Float star) {
        this.star = star;
    }
}
