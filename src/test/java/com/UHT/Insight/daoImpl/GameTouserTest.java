package com.UHT.Insight.daoImpl;

import com.UHT.Insight.pojo.*;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
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
    public void findGameTouserCountByGId(){
        System.out.println(gameTouserDao.findGameTouserCountByGId(168332));
    }
    @Test
    public void findGameTouserPageByGId(){
        System.out.println(gameTouserDao.findGameTouserPageByGId(168332,1,10));
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
        List<GameEverydayData> countEverydayAll = gameTouserDao.findCountEverydayAll(168332);
        System.out.println(countEverydayAll);
    }
    @Test
    public void findCountByDay(){
        Date date=null;
        try {
            date= new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-15");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(gameTouserDao.findCountByDay(date,168332));
    }
    @Test
    public void findCountAfterDayA(){
        Date date=null;
        try {
            date= new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(gameTouserDao.findCountAfterDayA(date,168332));
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
        System.out.println(gameTouserDao.findCountBetweenDayAAndB(date,date1,168332));
    }
    @Test
    public void findCountByStar(){
        List<GameStarLevel> countByStar = gameTouserDao.findCountByStar(4, 168332);
        System.out.println(countByStar);
    }
    @Test
    public void findCountByStarAll(){
        List<GameStarLevel> countByStar = gameTouserDao.findCountByStar(168332);
        System.out.println(gameTouserDao.findCountByStar(168332));
    }
    @Test
    public void findCountStarByDay(){
        Date date=null;
        try {
            date=new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GameStarLevel countStarByDay = gameTouserDao.findCountStarByDay(2, date, 168332);

        System.out.println(countStarByDay);
    }
    @Test
    public void findCountStarAfterDay(){
        Date date=null;
        try {
            date=new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(gameTouserDao.findCountStarAfterDay(2,date,168332));
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

        System.out.println(gameTouserDao.findCountStarBetweenDay(1,date,date1,168332));
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
    @Test
    public void findUnionByGId(){
        List<TapUserAndGameToUser> list=gameTouserDao.findUnionByGId(-1,-1,"QQ",-1,-1,-1,-1,-1,-1.0f,-1);
        System.out.println(list);

    }
}
