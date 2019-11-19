package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.GameBasic;

import java.util.List;

public interface GameBasicDao {
    /*查询所有GameBasic
    * @return
     */
    List<GameBasic> findAll();
    //根据id查询
    GameBasic findGBById(Integer G_ID);
    //根据id删除
    Integer deleteGameBasic(Integer G_ID);
    //更新
    Integer updateGameBasic(GameBasic gameBasic);
    //插入
    Integer saveGameBasic(GameBasic gameBasic);
}
