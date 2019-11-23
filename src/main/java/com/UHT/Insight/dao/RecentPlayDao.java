package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.RecentPlay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface RecentPlayDao {
    //查询所有
    List<RecentPlay> findAll();
    //插入
    Integer saveRecentPlay(RecentPlay recentPlay);
    //根据ID查询
    RecentPlay findRecentPlayById(Integer R_ID);
    //根据Id修改
    Integer updateRecentPlay(RecentPlay recentPlay);
    //根据ID删除
    Integer deleteRecentPlayById(Integer R_ID);
}
