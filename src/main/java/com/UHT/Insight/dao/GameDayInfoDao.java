package com.UHT.Insight.dao;

import com.UHT.Insight.dto.GameDayInfo;

import java.util.Date;
import java.util.List;

public interface GameDayInfoDao {
    //查询所有
    List<GameDayInfo> findGameDayInfoAll();
    //根据发布时间查询
    GameDayInfo findGameDayInfoByDay(Date time);
    //根据发布时间删除
    Integer deleteGameDayInfoByDay(Date time);
    //单条更新
    Integer updateGameDayInfoByOne(GameDayInfo gameDayInfo);
    //批量更新
    Integer updateGameDayInfoByList(List<GameDayInfo> list);
    //单条插入
    Integer saveGameDayInfoByOne(GameDayInfo gameDayInfo);
    //批量插入
    Integer saveGameDayInfoByList(List<GameDayInfo> list);
}
