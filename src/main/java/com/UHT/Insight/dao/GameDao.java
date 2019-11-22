package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.Game;

import java.util.List;

public interface GameDao {
    /**
     * 查询所有GameTouser
     * @return list
     */
    List<Game> findAll();
    //插入
    Integer saveGame(Game game);
    //根据id查询
    Game findGameById(Integer G_ID);
    //根据id删除
    Integer deleteGameById(Integer G_ID);
    //根据id修改
    Integer updateGame(Game game);

}
