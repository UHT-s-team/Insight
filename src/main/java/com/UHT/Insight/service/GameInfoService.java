package com.UHT.Insight.service;

import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.exception.CustomErrorCode;
import com.UHT.Insight.exception.CustomException;
import com.UHT.Insight.pojo.GameEverydayData;
import com.UHT.Insight.pojo.GameStarLevel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameInfoService {
    private GameToUserDaoImpl gameToUserDao=new GameToUserDaoImpl();

    public List<GameDayInfo> getGameDayInfoList(Integer gameId){
        List<GameDayInfo> gameDayInfos=new ArrayList<>();
        gameToUserDao=new GameToUserDaoImpl();
        List<GameEverydayData> everydayBaseData = gameToUserDao.findCountEverydayAll(gameId);
        if(everydayBaseData.size()==0){
            throw new CustomException(CustomErrorCode.GAME_NOT_FIND);
        }
        gameToUserDao=new GameToUserDaoImpl();
        List<GameStarLevel> everydayAllStar = gameToUserDao.findCountByStar(gameId);
        GameDayInfo gameInfo= new GameDayInfo();
        for(GameEverydayData gameEverydayData:everydayBaseData){
            BeanUtils.copyProperties(gameEverydayData, gameInfo);
            gameDayInfos.add(gameInfo);
            gameInfo=new GameDayInfo();
        }

        for(GameDayInfo gameDayInfo:gameDayInfos){
            for(GameStarLevel gameStarLevel:everydayAllStar){
                int compareTo = gameDayInfo.getTime().compareTo(gameStarLevel.getTime());
                if(compareTo==0){
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
        }
        return gameDayInfos;
    }
}
