package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.GameDao;
import com.UHT.Insight.pojo.Game;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl  {
    private SqlSession sqlSession= MybatilsUtils.getSession();
    private GameDao gameDao=sqlSession.getMapper(GameDao.class);
    //执行查询所有方法
    public List<Game> findAll(){
        List<Game> games=null;
        try {
           games = gameDao.findAll();
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return games;
        }finally {
            sqlSession.close();
        }
        return games;
    }
      //插入Game
    public Integer saveGame(Game game){
        int i=-1;
        try {
            i=gameDao.saveGame(game);
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
      //根据Id查询
    public Game findGameById(Integer G_ID) {
        Game game=null;
        try {
            game=gameDao.findGameById(G_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return game;
        }finally {
            sqlSession.close();
        }
        return game;
    }
    //删除
    public Integer deleteGameById(Integer G_ID) {
        int i=-1;
        try {
            i=gameDao.deleteGameById(G_ID);
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
      //更新
    public Integer updateGame(Game game) {
        int i=0;
        try {
            i=gameDao.updateGame(game);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
    //批量插入
    public Integer saveGameList(List<Game> list){
        int i=-1;
        try {
            i=gameDao.saveGameList(list);
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }

    public List<Game> searchByKeyword(String keyword){
        List<Game> games=null;
        try {
            games = gameDao.searchByKeyword(keyword);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return games;
        }finally {
            sqlSession.close();
        }
        return games;
    }
}
