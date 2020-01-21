package com.UHT.Insight.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AdvancedQueryDTO {
    private Integer u_id;         //用户Id
    private String u_name;        //当前用户名
    private Integer fans;       //粉丝数
    private Integer attention;     //关注数
    private Integer collect;      //收藏数
    private Integer play;    //玩过游戏数
    private Integer l_play;      //玩得最久游戏数
    private Integer appraise;         //评价数
    private  Float g_weight;       //评分权重
    private Integer p_flay;       //玩家属性标记  1为疑似水军   2为核心玩家    3为普通玩家
    private String t_flay;        //玩家类型标记
    private Date updateTime;      //玩家信息更新时间
}
