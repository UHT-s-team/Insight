package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.pojo.KeyWordCache;
import com.UHT.Insight.service.GameInfoService;
import com.UHT.Insight.utils.CacheUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;


public class KeyWordCacheTest {
    private KeyWordCacheDaoImpl keyWordCacheDao=new KeyWordCacheDaoImpl();
    //读取数据
    @Test
    public void findKeyWordCacheById(){
        KeyWordCache keyWordCache=keyWordCacheDao.findKeyWordCacheById(1111);
        System.out.println(keyWordCache);
    }
    //插入数据
    @Test
    public void saveKeyWordDataCache(){
        GameInfoService gameInfoService=new GameInfoService();
        List<GameDayInfo> list=gameInfoService.getGameDayInfoList(168332);
        byte[] bytes=null;
        try {
            bytes= CacheUtils.obj2byte(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date date=new Date(System.currentTimeMillis());
        KeyWordCache keyWordCache=new KeyWordCache(1111,bytes,date);
        int i=keyWordCacheDao.saveKeyWordDataCache(keyWordCache);
        System.out.println(i);
    }
    //更新数据
    @Test
    public void updateKeyWordDataCache(){
        GameInfoService gameInfoService=new GameInfoService();
        List<GameDayInfo> list=gameInfoService.getGameDayInfoList(168332);
        byte[] bytes=null;
        try {

            bytes= CacheUtils.obj2byte(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date date=new Date(System.currentTimeMillis());
        KeyWordCache keyWordCache=new KeyWordCache(1111,bytes,date);
        keyWordCacheDao.updateKeyWordDataCache(keyWordCache);
    }
    //查找所有的id及创建时间
    @Test
    public void findAllKeyWordDataCache(){
        List<KeyWordCache> list=null;
        list=keyWordCacheDao.findAllKeyWordDataCache();
        System.out.println(list);
    }
}
