package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.GameDayInfoDao;
import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class GameDayInfoDaoImpl{
    private SqlSession sqlSession= MybatilsUtils.getSession();
    private GameDayInfoDao gameDayInfoDao=sqlSession.getMapper(GameDayInfoDao.class);
    public List<GameDayInfo> findGameDayInfoAll() {
        List<GameDayInfo> list=null;
        try {
            list = gameDayInfoDao.findGameDayInfoAll();
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }


    public GameDayInfo findGameDayInfoByDay(Date time) {
        GameDayInfo gameDayInfo=null;
        try {
            gameDayInfo=gameDayInfoDao.findGameDayInfoByDay(time);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return gameDayInfo;
        }
        return gameDayInfo;
    }


    public Integer deleteGameDayInfoByDay(Date time) {
       Integer i=-1;
        try {
            i=gameDayInfoDao.deleteGameDayInfoByDay(time);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }


    public Integer updateGameDayInfoByOne(GameDayInfo gameDayInfo) {
        Integer i=0;
        try {
            i=gameDayInfoDao.updateGameDayInfoByOne(gameDayInfo);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }


    public Integer updateGameDayInfoByList(List<GameDayInfo> list) {
        Integer i=0;
        try {
            i=gameDayInfoDao.updateGameDayInfoByList(list);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }


    public Integer saveGameDayInfoByOne(GameDayInfo gameDayInfo) {
        Integer i=-1;
        try {
            i=gameDayInfoDao.saveGameDayInfoByOne(gameDayInfo);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }


    public Integer saveGameDayInfoByList(List<GameDayInfo> list) {
        Integer i=0;
        try {
            i=gameDayInfoDao.saveGameDayInfoByList(list);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
}
