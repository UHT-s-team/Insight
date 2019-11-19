package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.RecentAppraise;

import java.util.List;

public interface RecentAppraiseDao {
    //查询所有
    List<RecentAppraise> findAll();
    //插入
    Integer saveRecentAppraise(RecentAppraise recentAppraise);
    //根据id查询
    RecentAppraise findRecentAppraiseById(Integer G_ID);
    //根据id删除
    Integer deleteRecentAppraiseById(Integer G_ID);
    //根据id修改
    Integer updateRecntAppraise(RecentAppraise recentAppraise);
}
