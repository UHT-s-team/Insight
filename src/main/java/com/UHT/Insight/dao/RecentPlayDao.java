package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.RecentPlay;

import java.util.List;

public interface RecentPlayDao {
    //查询所有
    List<RecentPlay> findAll();
    //插入
    Integer saveRecentPlay(RecentPlay recentPlay);
    //根据ID查询
    RecentPlay findRecentPlayById(Integer G_ID);
    //根据Id修改
    Integer updateRecentPlay(RecentPlay recentPlay);
    //根据ID删除
    Integer deleteRecentPlayById(Integer G_ID);
}
