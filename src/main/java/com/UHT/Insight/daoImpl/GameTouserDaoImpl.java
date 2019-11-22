package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.GameTouserDao;
import com.UHT.Insight.pojo.GameEverydayData;
import com.UHT.Insight.pojo.GameStarLevel;
import com.UHT.Insight.pojo.GameTouser;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class GameTouserDaoImpl implements GameTouserDao {
    private SqlSession sqlSession=MybatilsUtils.getSession();
    private GameTouserDao gameTouserDao=sqlSession.getMapper(GameTouserDao.class);
    //查询所有GameTouser
    public List<GameTouser> findAll(){
        List<GameTouser> list=null;
        try {
            list = gameTouserDao.findAll();
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //插入GammeTouser
    public Integer saveGameTouser(GameTouser gameTouser){
        int i=-1;
        try {
            i=gameTouserDao.saveGameTouser(gameTouser);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
   //根据ID查询
    public GameTouser findGameTouserById(Integer D_ID){
        GameTouser gameTouser=null;
        try{
            gameTouser=gameTouserDao.findGameTouserById(D_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return gameTouser;
        }
        return gameTouser;
    }
    //删除
    public Integer deleteGameTouser(Integer D_ID){
        int i=-1;
        try{
           i=gameTouserDao.deleteGameTouser(D_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //更新
    public Integer updateGameTouser(GameTouser gameTouser){
        int i=-1;
        try{
           i=gameTouserDao.updateGameTouser(gameTouser);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //每天的评论数量和平均星级
    public List<GameEverydayData> findCountEverydayAll() {
        List<GameEverydayData> list=null;
        try {
            list = gameTouserDao.findCountEverydayAll();
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //每天的各星级数量
    public List<GameStarLevel> findCountByStar(Float D_START) {
        List<GameStarLevel> list=null;
        try {
            list = gameTouserDao.findCountByStar(D_START);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //1-5星的每天数量
    public List<GameStarLevel> findCountByStar() {
        List<GameStarLevel> list=null;
        List<GameStarLevel> list1=null;
        List<GameStarLevel> list2=null;
        List<GameStarLevel> list3=null;
        List<GameStarLevel> list4=null;
        try {
            list = gameTouserDao.findCountByStar(1f);
            list1 = gameTouserDao.findCountByStar(2f);
            list2 = gameTouserDao.findCountByStar(3f);
            list3 = gameTouserDao.findCountByStar(4f);
            list4 = gameTouserDao.findCountByStar(5f);
            list.addAll(list1);
            list.addAll(list2);
            list.addAll(list3);
            list.addAll(list4);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
}
