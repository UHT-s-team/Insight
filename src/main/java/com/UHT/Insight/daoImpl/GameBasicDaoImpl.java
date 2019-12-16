package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.GameBasicDao;
import com.UHT.Insight.pojo.GameBasic;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GameBasicDaoImpl {
    private SqlSession sqlSession= MybatilsUtils.getSession();
    private GameBasicDao gameBasicDao=sqlSession.getMapper(GameBasicDao.class);
    //查询所有
    public List<GameBasic> findAll(){
        List<GameBasic> list=null;
        try {
            list = gameBasicDao.findAll();
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }finally {
            sqlSession.close();
        }
        return list;
    }
    //根据ID查询
    public GameBasic findGBById(Integer G_ID){
        GameBasic gameBasic=null;
        try{
            gameBasic=gameBasicDao.findGBById(G_ID);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return gameBasic;
        }finally {
            sqlSession.close();
        }
        return gameBasic;
    }
    //根据id删除
    public Integer deleteGameBasic(Integer G_ID){
        int i=-1;
        try{
          gameBasicDao.deleteGameBasic(G_ID);
           sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
    //更新
    public Integer updateGameBasic(GameBasic gameBasic){
        int i=0;
        try{
           i=gameBasicDao.updateGameBasic(gameBasic);
           sqlSession.commit();
        }catch(Exception e){
           e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
    //插入
    public Integer saveGameBasic(GameBasic gameBasic){
        int i=-1;
        try{
           i=gameBasicDao.saveGameBasic(gameBasic);
           sqlSession.commit();
        }catch(Exception e){
           e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
}
