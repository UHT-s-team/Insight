package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.GameDayInfoCache;

public interface GameDayInfoCacheDao {
    //读取数据
    public GameDayInfoCache findGameDataCacheById(Integer G_ID);
    //插入数据
    public Integer saveGameDataCache(GameDayInfoCache gameDayInfoCache);
    //更新数据
    public Integer updateGameDataCache(GameDayInfoCache gameDayInfoCache);
}
