package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.GameDao;
import com.UHT.Insight.pojo.Game;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class GameDaoImpl implements GameDao {
    private SqlSession sqlSession= MybatilsUtils.getSession();
    private GameDao gameDao=sqlSession.getMapper(GameDao.class);
    //执行查询所有方法
    public List<Game> findAll(){
        List<Game> games=null;
        try {
           games = gameDao.findAll();
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return games;
    }
      //插入Game
    public Integer saveGame(Game game){
        int i=-1;
        try {
            i=gameDao.saveGame(game);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
      //根据Id查询
    public Game findGameById(Integer G_ID) {
        Game game=null;
        try {
            game=gameDao.findGameById(G_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return game;
    }
    //删除
    public Integer deleteGameById(Integer G_ID) {
        int i=-1;
        try {
            i=gameDao.deleteGameById(G_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
      //更新
    public Integer updateGame(Game game) {
        int i=-1;
        try {
            i=gameDao.updateGame(game);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }

    public List<Game> selectGameListLikeName(Game game) {
        List<Game> games=null;
        try {
            games = gameDao.selectGameListLikeName(game);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return games;
    }

    public Integer selectGameListCountLikeName(Game game) {
        int i=-1;
        try {
            i=gameDao.selectGameListCountLikeName(game);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
}
