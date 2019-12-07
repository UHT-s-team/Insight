package com.UHT.Insight.dao;

        import com.UHT.Insight.dto.T_GameDayInfoCacheDTO;
        import com.UHT.Insight.pojo.GameDayInfoCache;

        import java.util.List;

public interface GameDayInfoCacheDao {
    //读取数据
    public GameDayInfoCache findGameDataCacheById(Integer G_ID);
    //插入数据
    public Integer saveGameDataCache(GameDayInfoCache gameDayInfoCache);
    //更新数据
    public Integer updateGameDataCache(GameDayInfoCache gameDayInfoCache);
    //查找所有的id及创建时间
    public List<T_GameDayInfoCacheDTO> findAllGameDataCache();

}
