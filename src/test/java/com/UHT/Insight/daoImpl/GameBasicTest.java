package com.UHT.Insight.daoImpl;

import com.UHT.Insight.pojo.GameBasic;
import org.junit.Test;

import java.util.List;

public class GameBasicTest {
    private GameBasicDaoImpl gameBasicDao=new GameBasicDaoImpl();
    @Test
    public void findAll(){
        List<GameBasic> list=gameBasicDao.findAll();
        for (GameBasic gameBasic:list) {
            System.out.println(gameBasic.toString());
        }
    }
    //根据id查询
    @Test
    public void findGBById(){
        System.out.println(gameBasicDao.findGBById(232132));
    }
    //根据id删除
    @Test
    public void deleteGameBasic(){
        System.out.println(gameBasicDao.deleteGameBasic(232131));
    }
    //更新
    @Test
    public void updateGameBasic(){
        GameBasic gameBasic=new GameBasic(232131,"英雄联盟", (float)11.1,(float)7.1, (float)7.1);
        System.out.println(gameBasicDao.updateGameBasic(gameBasic));
    }
    //插入
    @Test
    public void saveGameBasic(){
        GameBasic gameBasic=new GameBasic(232131,"英雄联盟", (float)3.1,(float)7.1, (float)7.1);
        gameBasicDao.saveGameBasic(gameBasic);
    }
}
