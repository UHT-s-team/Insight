package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.GameTouserDao;
import com.UHT.Insight.pojo.GameEverydayData;
import com.UHT.Insight.pojo.GameStarLevel;
import com.UHT.Insight.pojo.GameTouser;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class GameToUserDaoImpl{
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
    //插入GameToUser
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
        int i=0;
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
    //每天的评论数量和平均星级（所有）
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
    //具体某一天的评论数量和评价星级---
    public GameEverydayData findCountByDay(Date I_TIME) {
        GameEverydayData gameEverydayData=new GameEverydayData();
        try {
            gameEverydayData = gameTouserDao.findCountByDay(I_TIME);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return gameEverydayData;
        }
        return gameEverydayData;
    }
    //从某天开始的评论数量和星级------
    public List<GameEverydayData> findCountAfterDayA(Date start) {
        List<GameEverydayData> list=null;
        try {
            list = gameTouserDao.findCountAfterDayA(start);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //从某天到某天的评论数量和星级-----
    public List<GameEverydayData> findCountBetweenDayAAndB(Date start, Date end) {
        List<GameEverydayData> list=null;
        try {
            list = gameTouserDao.findCountBetweenDayAAndB(start,end);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }

    //每天的各星级数量
    public List<GameStarLevel> findCountByStar(Integer D_START) {
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
        List<GameStarLevel> list=new ArrayList<>();
        try {
            list.addAll(gameTouserDao.findCountByStar(1)) ;
            list.addAll(gameTouserDao.findCountByStar(2)) ;
            list.addAll(gameTouserDao.findCountByStar(3)) ;
            list.addAll(gameTouserDao.findCountByStar(4)) ;
            list.addAll(gameTouserDao.findCountByStar(5)) ;
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    /*{ 参数star（星级），start（开始时间）,end（结束时间）的值}
     *时间格式 Date date= new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-00");
     * */
    //具体一天的各星级数量----star（星级） start(当天日期)
    public GameStarLevel findCountStarByDay(Integer star,Date start) {
        GameStarLevel gameStarLevel=null;
        Map<String,Object> map=new HashMap<>();
        map.put("star",star);
        map.put("start",start);
        try {
            gameStarLevel = gameTouserDao.findCountStarByDay(map);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return gameStarLevel;
        }
        return gameStarLevel;
    }
    //从某天开始的各星级数量----star（星级） start(开始日期)
    public List<GameStarLevel> findCountStarAfterDay(Integer star,Date start) {
        List<GameStarLevel> list=null;
        Map<String,Object> map=new HashMap<>();
        map.put("star",star);
        map.put("start",start);
        try {
            list =gameTouserDao.findCountStarAfterDay(map);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //从某天到某天的各星级数量------star（星级） start(开始日期) end(结束)
    public List<GameStarLevel> findCountStarBetweenDay(Integer star,Date start,Date end) {
        List<GameStarLevel> list=null;
        Map<String,Object> map=new HashMap<>();
        map.put("star",star);
        map.put("start",start);
        map.put("end",end);
        try {
            list =gameTouserDao.findCountStarBetweenDay(map);
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //批量插入
    public Integer addGameList(List<GameTouser> list) {
        int i=-1;
        try {
            i=gameTouserDao.addGameList(list);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
}
