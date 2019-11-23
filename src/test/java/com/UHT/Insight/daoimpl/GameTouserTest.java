package com.UHT.Insight.daoimpl;

import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.pojo.GameTouser;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void findCountByStar(){
        System.out.println(gameTouserDao.findCountByStar(5));
    }
    @Test
    public void findCountByStarAll(){
        System.out.println(gameTouserDao.findCountByStar());
    }
}
