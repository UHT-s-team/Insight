package com.UHT.Insight.provide;

import com.UHT.Insight.daoImpl.GameDayInfoCacheDaoImpl;
import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.dto.T_GameDayInfoCacheDTO;
import com.UHT.Insight.pojo.GameDayInfoCache;
import com.UHT.Insight.service.GameInfoService;
import com.UHT.Insight.utils.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class AutoUpdateGameInfo {


    @Autowired
    private GameInfoService gameInfoService;

    private GameDayInfoCacheDaoImpl  gameDayInfoCacheDao= new GameDayInfoCacheDaoImpl();


    @Scheduled(cron = "0 0 4 * * ?" )//每天四点启动
    public void UpdateGameDayInfoCache() throws Exception {//更新游戏缓冲数据表
        List<T_GameDayInfoCacheDTO> allGameDataCache = gameDayInfoCacheDao.findAllGameDataCache();
        //查询缓冲表内所有游戏
        for(T_GameDayInfoCacheDTO gameDataCacheDTO:allGameDataCache){
            //遍历缓冲数据
            Date createTime = gameDataCacheDTO.getCreateTime();
            Date yesterday = GetAnyTime(-1);//获得日期为一天前的Date对象
            if(createTime.compareTo(yesterday)<0){//判断缓冲数据是否是昨天之前的
                List<GameDayInfo> gameDayInfoList = gameInfoService.getGameDayInfoList(gameDataCacheDTO.getG_ID());
                //重新获取缓冲数据
                byte[] InfoBytes = CacheUtils.obj2byte(gameDayInfoList);
                GameDayInfoCache cache=new GameDayInfoCache();
                {
                    cache.setCreateTime(new Date(System.currentTimeMillis()));
                    cache.setInfoCache(InfoBytes);
                    cache.setG_ID(gameDataCacheDTO.getG_ID());
                }
                gameDayInfoCacheDao.updateGameDataCache(cache);
                //更新缓冲数据表
            }
        }
        System.out.println("更新成功");
    }

    private static Date GetAnyTime(Integer t) {//获得基于当前时间的前几天后几天之类的工具
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, t);
        date = calendar.getTime();
        return date;
    }
}
