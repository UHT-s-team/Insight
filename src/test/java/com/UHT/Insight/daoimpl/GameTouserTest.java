package com.UHT.Insight.daoimpl;

import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.pojo.GameTouser;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GameTouserTest {
    private GameToUserDaoImpl gameTouserDao = new GameToUserDaoImpl();
    @Test
    public void saveGameTouser(){
        try {
            Date date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-11-15 16:14:0");
            System.out.println(date);
            GameTouser gameTouser = new GameTouser(599, 1, 1, "黄牛你",date,1, "", "dfd", "华为", 1, 1, 1, 1);
            System.out.println(gameTouserDao.saveGameTouser(gameTouser));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void findAll(){
        System.out.println(gameTouserDao.findAll());
    }
    @Test
    public void findGameTouserById(){
        System.out.println(gameTouserDao.findGameTouserById(2));
    }
    @Test
    public void updateGameTouser(){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-11-15 16:14:0");
            GameTouser gameTouser = new GameTouser(2, 2, 2, "dfdsf", date, 1, "", "dff", "小米", 232, 23233, 213, 1232);
            System.out.println(gameTouserDao.updateGameTouser(gameTouser));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void deleteGameTouser(){
        System.out.println(gameTouserDao.deleteGameTouser(1));
    }
    @Test
    public void  findCountEverydayAll(){
        System.out.println(gameTouserDao.findCountEverydayAll());
    }
    @Test
    public void findCountByDay(){
        Date date=null;
        try {
            date= new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-15");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(gameTouserDao.findCountByDay(date));
    }
    @Test
    public void findCountAfterDayA(){
        Date date=null;
        try {
            date= new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(gameTouserDao.findCountAfterDayA(date));
    }
    @Test
    public void findCountBetweenDayAAndB(){
        Date date=null;
        Date date1=null;
        try {
            date= new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-00");
            date1= new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-15");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(gameTouserDao.findCountBetweenDayAAndB(date,date1));
    }
    @Test
    public void findCountByStar(){
        System.out.println(gameTouserDao.findCountByStar(5));
    }
    @Test
    public void findCountByStarAll(){
        System.out.println(gameTouserDao.findCountByStar());
    }
    @Test
    public void findCountStarByDay(){
        Date date=null;
        try {
            date=new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<>();
        map.put("start",date);
        map.put("star",2);
        System.out.println(gameTouserDao.findCountStarByDay(map));
    }
    @Test
    public void findCountStarAfterDay(){
        Date date=null;
        try {
            date=new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<>();
        map.put("start",date);
        map.put("star",2);
        System.out.println(gameTouserDao.findCountStarAfterDay(map));
    }
    @Test
    public void findCountStarBetweenDay(){
        Date date=null;
        Date date1=null;
        try {
            date=new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-26");
            date1=new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<>();
        map.put("start",date);
        map.put("end",date1);
        map.put("star",2);
        System.out.println(gameTouserDao.findCountStarBetweenDay(map));
    }
    @Test
    public void addGameList(){
        try {
            Date date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-11-15 16:14:0");
            System.out.println(date);
            List<GameTouser> list=new ArrayList<>();
            list.add(new GameTouser(5954, 1, 1, "黄你",date,1, "", "dfd", "华为", 1, 1, 1, 1));
            list.add(new GameTouser(59945, 1, 1, "黄你",date,1, "", "dfd", "华为", 1, 1, 1, 1));
            list.add(new GameTouser(59966, 1, 1, "黄你",date,1, "", "dfd", "华为", 1, 1, 1, 1));
            list.add(new GameTouser(59961, 1, 1, "黄你",date,1, "", "dfd", "华为", 1, 1, 1, 1));
            gameTouserDao.addGameList(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
