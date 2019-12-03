package com.UHT.Insight.daoimpl;


import com.UHT.Insight.daoImpl.GameDayInfoCacheDaoImpl;
import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.dto.T_GameDayInfoCacheDTO;
import com.UHT.Insight.pojo.GameDayInfoCache;
import com.UHT.Insight.service.GameInfoService;
import com.UHT.Insight.utils.CacheUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class GameDayInfoCacheTest {
    private GameDayInfoCacheDaoImpl gameDayInfoCacheDao=new GameDayInfoCacheDaoImpl();
    @Test
    public void findGameDataCacheById(){
        GameDayInfoCache gameDayInfoCache=gameDayInfoCacheDao.findGameDataCacheById(168332);
        System.out.println(gameDayInfoCache);
    }
    @Test
    public void saveGameDataCache(){
        GameInfoService gameInfoService=new GameInfoService();
        List<GameDayInfo> list=gameInfoService.getGameDayInfoList(168332);
        byte[] bytes=null;
        try {
             bytes= CacheUtils.obj2byte(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date date=new Date(System.currentTimeMillis());
        GameDayInfoCache gameDayInfoCache=new GameDayInfoCache(168332,bytes,date);
        int i=gameDayInfoCacheDao.saveGameDataCache(gameDayInfoCache);
        System.out.println(i);
    }
    @Test
    public void updateGameDataCache(){
        GameInfoService gameInfoService=new GameInfoService();
        List<GameDayInfo> list=gameInfoService.getGameDayInfoList(168332);
        byte[] bytes=null;
        try {
            bytes= CacheUtils.obj2byte(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date date=new Date(System.currentTimeMillis());
        GameDayInfoCache gameDayInfoCache=new GameDayInfoCache(168332,bytes,date);
        int i=gameDayInfoCacheDao.updateGameDataCache(gameDayInfoCache);
        System.out.println(i);
    }
    @Test
    public void findAllGameDataCache(){
        List<T_GameDayInfoCacheDTO> allGameDataCache = gameDayInfoCacheDao.findAllGameDataCache();
        System.out.println(allGameDataCache);
    }
}
