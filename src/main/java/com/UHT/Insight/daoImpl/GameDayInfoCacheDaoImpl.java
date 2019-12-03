package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.GameDayInfoCacheDao;
import com.UHT.Insight.dto.T_GameDayInfoCacheDTO;
import com.UHT.Insight.pojo.GameDayInfoCache;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GameDayInfoCacheDaoImpl {
    private SqlSession sqlSession= MybatilsUtils.getSession();

    private GameDayInfoCacheDao gameDataCacheDao=sqlSession.getMapper(GameDayInfoCacheDao.class);
    //根据游戏id查找缓存数据
    public GameDayInfoCache findGameDataCacheById(Integer G_ID) {
        GameDayInfoCache gameDayInfoCache=null;
        try {
            gameDayInfoCache=gameDataCacheDao.findGameDataCacheById(G_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return gameDayInfoCache;
        }
        return gameDayInfoCache;
    }

    //保存缓存数据
    public Integer saveGameDataCache(GameDayInfoCache gameDayInfoCache) {
        int i=-1;
        try {
            i=gameDataCacheDao.saveGameDataCache(gameDayInfoCache);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }

    //更新缓存表数据
    public Integer updateGameDataCache(GameDayInfoCache gameDayInfoCache) {
        int i=-1;
        try {
            i=gameDataCacheDao.updateGameDataCache(gameDayInfoCache);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }

    public List<T_GameDayInfoCacheDTO> findAllGameDataCache(){
        List<T_GameDayInfoCacheDTO> t_gameDayInfoCacheDtoList=null;
        try {
            t_gameDayInfoCacheDtoList=gameDataCacheDao.findAllGameDataCache();
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return t_gameDayInfoCacheDtoList;
        }
        return t_gameDayInfoCacheDtoList;
    }
}
