package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.GameTouserDao;
import com.UHT.Insight.pojo.GameEverydayData;
import com.UHT.Insight.pojo.GameStarLevel;
import com.UHT.Insight.pojo.GameTouser;
import com.UHT.Insight.pojo.TapUserAndGameToUser;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class GameToUserDaoImpl{
    private MybatilsUtils mybatilsUtils=new MybatilsUtils();
    private SqlSession sqlSession=mybatilsUtils.getSession();
    private GameTouserDao gameTouserDao=sqlSession.getMapper(GameTouserDao.class);
    //查询所有GameTouser
    public List<GameTouser> findAll(){
        List<GameTouser> list=null;
        try {
            list = gameTouserDao.findAll();
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }finally {
            sqlSession.close();
        }
        return list;
    }


    //插入GameToUser
    public Integer saveGameTouser(GameTouser gameTouser){
        int i=-1;
        try {
            i=gameTouserDao.saveGameTouser(gameTouser);
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
   //根据ID查询
    public GameTouser findGameTouserById(Integer D_ID){
        GameTouser gameTouser=null;
        try{
            gameTouser=gameTouserDao.findGameTouserById(D_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return gameTouser;
        }finally {
            sqlSession.close();
        }
        return gameTouser;
    }
    public Integer findGameTouserCountByGId(Integer G_ID){
        Integer i=-1;
        try{
            i=gameTouserDao.findGameTouserCountByGId(G_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //根据ID分页查询
    public List<GameTouser> findGameTouserPageByGId(Integer G_ID,Integer start,Integer size){
        List<GameTouser> list=new ArrayList<>();
        try{
            list=gameTouserDao.findGameTouserPageByGId(G_ID,start,size);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //根据ID查询
    public List<GameTouser> findGameTouserByGId(Integer G_ID){
        List<GameTouser> list=new ArrayList<>();
        try{
            list=gameTouserDao.findGameTouserByGId(G_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //删除
    public Integer deleteGameTouser(Integer D_ID){
        int i=-1;
        try{
           i=gameTouserDao.deleteGameTouser(D_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }

    //根据游戏id删除评论
    public Integer deleteGameTouserByGameId(Integer G_ID){
        int i=-1;
        try{
            i=gameTouserDao.deleteGameTouserByGameId(G_ID);
            sqlSession.commit();
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
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //每天的评论数量和平均星级（所有）
    public List<GameEverydayData> findCountEverydayAll(Integer G_ID) {
        List<GameEverydayData> list=null;
        try {
            list = gameTouserDao.findCountEverydayAll(G_ID);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //具体某一天的评论数量和评价星级---
    public GameEverydayData findCountByDay(Date I_TIME,Integer G_ID) {
        GameEverydayData gameEverydayData=new GameEverydayData();
        Map<String,Object> map=new HashMap<>();
        map.put("I_TIME",I_TIME);
        map.put("G_ID",G_ID);
        try {
            gameEverydayData = gameTouserDao.findCountByDay(map);
           sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return gameEverydayData;
        }
        return gameEverydayData;
    }
    //从某天开始的评论数量和星级------
    public List<GameEverydayData> findCountAfterDayA(Date start,Integer G_ID) {
        List<GameEverydayData> list=null;
        Map<String,Object> map=new HashMap<>();
        map.put("start",start);
        map.put("G_ID",G_ID);
        try {
            list = gameTouserDao.findCountAfterDayA(map);
           sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //从某天到某天的评论数量和星级-----
    public List<GameEverydayData> findCountBetweenDayAAndB(Date start, Date end,Integer G_ID) {
        List<GameEverydayData> list=null;
        Map<String,Object> map=new HashMap<>();
        map.put("start",start);
        map.put("end",end);
        map.put("G_ID",G_ID);
        try {
            list = gameTouserDao.findCountBetweenDayAAndB(map);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }

    //每天的各星级数量
    public List<GameStarLevel> findCountByStar(Integer D_START,Integer G_ID) {
        List<GameStarLevel> list=null;
        try {
            list = gameTouserDao.findCountByStar(D_START,G_ID);
           sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //1-5星的每天数量
    public List<GameStarLevel> findCountByStar(Integer G_ID) {
        List<GameStarLevel> list=new ArrayList<>();
        try {
            list.addAll(gameTouserDao.findCountByStar(1,G_ID)) ;
            list.addAll(gameTouserDao.findCountByStar(2,G_ID)) ;
            list.addAll(gameTouserDao.findCountByStar(3,G_ID)) ;
            list.addAll(gameTouserDao.findCountByStar(4,G_ID)) ;
            list.addAll(gameTouserDao.findCountByStar(5,G_ID)) ;
            sqlSession.commit();
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
    public GameStarLevel findCountStarByDay(Integer star,Date start,Integer G_ID) {
        GameStarLevel gameStarLevel=null;
        Map<String,Object> map=new HashMap<>();
        map.put("star",star);
        map.put("start",start);
        map.put("G_ID",G_ID);
        try {
            gameStarLevel = gameTouserDao.findCountStarByDay(map);
           sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return gameStarLevel;
        }
        return gameStarLevel;
    }
    //从某天开始的各星级数量----star（星级） start(开始日期)
    public List<GameStarLevel> findCountStarAfterDay(Integer star,Date start,Integer G_ID) {
        List<GameStarLevel> list=null;
        Map<String,Object> map=new HashMap<>();
        map.put("star",star);
        map.put("start",start);
        map.put("G_ID",G_ID);
        try {
            list =gameTouserDao.findCountStarAfterDay(map);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //从某天到某天的各星级数量------star（星级） start(开始日期) end(结束)
    public List<GameStarLevel> findCountStarBetweenDay(Integer star,Date start,Date end,Integer G_ID) {
        List<GameStarLevel> list=null;
        Map<String,Object> map=new HashMap<>();
        map.put("star",star);
        map.put("start",start);
        map.put("end",end);
        map.put("G_ID",G_ID);
        try {
            list =gameTouserDao.findCountStarBetweenDay(map);
            sqlSession.commit();
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
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //tapUser表与gameToUser表的联合查询,Integer属性不查填-1，float填-1.0f，String为null 字符串为模糊查询
    public List<TapUserAndGameToUser> findUnionByGId(Integer G_ID,Integer U_ID,String U_NAME,Integer FANS,
         Integer ATTENTION,Integer COLLECT,Integer PLAY,Integer L_PLAY,Float G_WEIGHT,Integer APPRAISE){
        List<TapUserAndGameToUser> list=null;
        Map<String,Object> map=new HashMap<>();
        map.put("G_ID",G_ID);
        map.put("U_ID",U_ID);
        map.put("U_NAME",U_NAME);
        map.put("FANS",FANS);
        map.put("ATTENTION",ATTENTION);
        map.put("COLLECT",COLLECT);
        map.put("PLAY",PLAY);
        map.put("L_PLAY",L_PLAY);
        map.put("G_WEIGHT",G_WEIGHT);
        map.put("APPRAISE",APPRAISE);
        try {
            list = gameTouserDao.findUnionByGId(map);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }finally {
            sqlSession.close();
        }
        return list;
    }
}
