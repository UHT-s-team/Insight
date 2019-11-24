package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.GameEverydayData;
import com.UHT.Insight.pojo.GameStarLevel;
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
    //每天的评论数量和平均星级
    List<GameEverydayData> findCountEverydayAll();
    //每天的各星级数量
    List<GameStarLevel> findCountByStar(Integer D_START);
    //批量插入
    Integer addGameList(List<GameTouser> list);

}
