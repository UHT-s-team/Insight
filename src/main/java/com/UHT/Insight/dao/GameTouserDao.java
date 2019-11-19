package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.GameTouser;

import java.util.List;

public interface GameTouserDao {
    /**
     * 查询所有GameTouser
     * @return list
     */
    List<GameTouser> findAll();
    //插入数据
    Integer saveGameTouser(GameTouser gameTouser);
    //根据id查询
    GameTouser findGameTouserById(Integer D_ID);
    //根据id删除
    Integer deleteGameTouser(Integer D_ID);
    //更新
    Integer updateGameTouser(GameTouser gameTouser);

}