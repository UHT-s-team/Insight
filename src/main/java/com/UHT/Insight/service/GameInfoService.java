package com.UHT.Insight.service;

import com.UHT.Insight.daoImpl.GameDaoImpl;
import com.UHT.Insight.daoImpl.GameDayInfoCacheDaoImpl;
import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.exception.CustomErrorCode;
import com.UHT.Insight.exception.CustomException;
import com.UHT.Insight.pojo.Game;
import com.UHT.Insight.pojo.GameDayInfoCache;
import com.UHT.Insight.pojo.GameEverydayData;
import com.UHT.Insight.pojo.GameStarLevel;
import com.UHT.Insight.utils.CacheUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.UHT.Insight.utils.CacheUtils.obj2byte;

@Service
public class GameInfoService {
    private GameToUserDaoImpl gameToUserDao=new GameToUserDaoImpl();
    private GameDaoImpl gameDao = new GameDaoImpl();
    private GameDayInfoCacheDaoImpl gameDayInfoCacheDao=new GameDayInfoCacheDaoImpl();

    public List<GameDayInfo> getGameDayInfoList(Integer gameId){
        List<GameDayInfo> gameDayInfos=new ArrayList<>();
        gameToUserDao=new GameToUserDaoImpl();//用处不明，但是确实能解决问题
        List<GameEverydayData> everydayBaseData = gameToUserDao.findCountEverydayAll(gameId);
        //根据游戏id查询游戏的基本信息
        if(everydayBaseData.size()==0){
            throw new CustomException(CustomErrorCode.GAME_NOT_FIND);//抛出异常
        }
        gameToUserDao=new GameToUserDaoImpl();
        //重新实例化dao对象，因为只要使用过一次，连接就会被关闭
        List<GameStarLevel> everydayAllStar = gameToUserDao.findCountByStar(gameId);
        //根据游戏id，获取每日的各星级数量 （从1到5）
        GameDayInfo gameInfo= new GameDayInfo();//无意义的工具
        for(GameEverydayData gameEverydayData:everydayBaseData){
            BeanUtils.copyProperties(gameEverydayData, gameInfo);
            gameDayInfos.add(gameInfo);
            gameInfo=new GameDayInfo();//重新实例化工具
        }
        //将everydayBaseData整体数据迁移到gameDayInfos内

        float this_avgScore=0;//当前的平均评分
        int this_comments=0;//当前的评价数量
        for(GameDayInfo gameDayInfo :gameDayInfos){//遍历gameDayInfos
            for(GameStarLevel gameStarLevel:everydayAllStar){
                int compareTo=1;
                try{
                    compareTo = gameDayInfo.getTime().compareTo(gameStarLevel.getTime());
                }catch(Exception e){
                    e.printStackTrace();
                }
                if(compareTo==0){//通过比对时间，将各星级数量加载到对应的gameDayInfo
                    switch (gameStarLevel.getStar()){
                        case 1:
                            gameDayInfo.setOneStarNum(gameStarLevel.getNum());
                            break;
                        case 2:
                            gameDayInfo.setTwoStarNum(gameStarLevel.getNum());
                            break;
                        case 3:
                            gameDayInfo.setThreeStarNum(gameStarLevel.getNum());
                            break;
                        case 4:
                            gameDayInfo.setFourStarNum(gameStarLevel.getNum());
                            break;
                        case 5:
                            gameDayInfo.setFiveStarNum(gameStarLevel.getNum());
                            break;
                    }
                }
            }
            this_avgScore=(this_avgScore*this_comments+gameDayInfo.getAverage()*gameDayInfo.getNum())/(this_comments+gameDayInfo.getNum());
            //当天的历史评分，依据当天的平均评分及前一天的历史评分
            this_comments+=gameDayInfo.getNum();
            gameDayInfo.setHistoryScore(this_avgScore);
        }
        return gameDayInfos;
    }

    public List<GameDayInfo> findGameInfoCache(Integer id) throws Exception {
        GameDayInfoCache gameDayInfoCache = gameDayInfoCacheDao.findGameDataCacheById(id);
        if(gameDayInfoCache!=null){
            List<GameDayInfo> GameDayInfo = (List<GameDayInfo>)CacheUtils.byte2obj(gameDayInfoCache.getInfoCache());
            return GameDayInfo;
        }
        return null;
    }

    public void saveGameInfoCache(Integer id, List<GameDayInfo> gameDayInfoList) throws Exception {
        GameDayInfoCache gameDayInfoCache = new GameDayInfoCache();
        gameDayInfoCache.setG_ID(id);
        gameDayInfoCache.setInfoCache(obj2byte(gameDayInfoList));
        gameDayInfoCache.setCreateTime(new Date(System.currentTimeMillis()));
        gameDayInfoCacheDao.saveGameDataCache(gameDayInfoCache);
    }

    public List<Game> searchGameByKeyword(String keyword){
        List<Game> games = null;
        if (StringUtils.isNotBlank(keyword)) {
            String[] searchs = keyword.split(" ");
            String collect = Arrays.stream(searchs).collect(Collectors.joining("|"));
            try {
                games = gameDao.searchByKeyword(collect);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return games;
    }
}
