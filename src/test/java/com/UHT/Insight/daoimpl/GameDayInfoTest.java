package com.UHT.Insight.daoimpl;

import com.UHT.Insight.daoImpl.GameDayInfoDaoImpl;
import com.UHT.Insight.dto.GameDayInfo;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameDayInfoTest {
    private GameDayInfoDaoImpl gameDayInfoDao=new GameDayInfoDaoImpl();
    @Test
    public void find(){
     System.out.println(gameDayInfoDao.findGameDayInfoAll().toString());
    }
        @Test
    public void findGameDayInfoByDay(){
            Date date= null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-1");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(gameDayInfoDao.findGameDayInfoByDay(date).toString());
    }
    @Test
    public void deleteGameDayInfoByDay(){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(gameDayInfoDao.deleteGameDayInfoByDay(date));
    }
    @Test
    public void updateGameDayInfoByOne(){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GameDayInfo gameDayInfo=new GameDayInfo();
        gameDayInfo.setTime(date);
        gameDayInfo.setNum(123);
        gameDayInfo.setAverage(5.2f);
        gameDayInfo.setOneStarNum(213);
        gameDayInfo.setTwoStarNum(344);
        gameDayInfo.setThreeStarNum(3434);
        gameDayInfo.setFourStarNum(2323);
        gameDayInfo.setFiveStarNum(3434);
        System.out.println(gameDayInfoDao.updateGameDayInfoByOne(gameDayInfo));
    }@Test
    public void updateGameDayInfoByList(){
        List<GameDayInfo> list=new ArrayList<>();
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GameDayInfo gameDayInfo=new GameDayInfo();
        gameDayInfo.setTime(date);
        gameDayInfo.setNum(123);
        gameDayInfo.setAverage(4.2f);
        gameDayInfo.setOneStarNum(213);
        gameDayInfo.setTwoStarNum(344);
        gameDayInfo.setThreeStarNum(3434);
        gameDayInfo.setFourStarNum(2323);
        gameDayInfo.setFiveStarNum(3434);
        list.add(gameDayInfo);
        System.out.println(gameDayInfoDao.updateGameDayInfoByList(list));
    }
    @Test
    public void saveGameDayInfoByOne(){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GameDayInfo gameDayInfo=new GameDayInfo();
        gameDayInfo.setTime(date);
        gameDayInfo.setNum(123);
        gameDayInfo.setAverage(1.2f);
        gameDayInfo.setOneStarNum(213);
        gameDayInfo.setTwoStarNum(344);
        gameDayInfo.setThreeStarNum(3434);
        gameDayInfo.setFourStarNum(2323);
        gameDayInfo.setFiveStarNum(3434);
        System.out.println(gameDayInfoDao.saveGameDayInfoByOne(gameDayInfo));
    }
    @Test
    public void saveGameDayInfoByList(){
        List<GameDayInfo> list=new ArrayList<>();
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-1");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GameDayInfo gameDayInfo=new GameDayInfo();
        gameDayInfo.setTime(date);
        gameDayInfo.setNum(123);
        gameDayInfo.setAverage(1.2f);
        gameDayInfo.setOneStarNum(213);
        gameDayInfo.setTwoStarNum(344);
        gameDayInfo.setThreeStarNum(3434);
        gameDayInfo.setFourStarNum(2323);
        gameDayInfo.setFiveStarNum(3434);
        list.add(gameDayInfo);
        System.out.println(gameDayInfoDao.saveGameDayInfoByList(list));
    }


}
