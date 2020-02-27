package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.GameTouserDao;
import com.UHT.Insight.pojo.*;
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
        {
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
        }
        try {
            list = gameTouserDao.findUnionByGId(map);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }return list;
    }
    //对比tapUser和gameToUser表，查询gameToUser表存在而tapUserb表不存在的用户
    //返回值 U_ID,此U_ID对应的评论数量
    List<CompareUser> CompareTapAndGameUser(){
        List<CompareUser> list=null;
        try {
            list = gameTouserDao.CompareTapAndGameUser();
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }

    public List<GameTouser> hotComment(Integer gameId,Integer num){
        List<GameTouser> hotComment=null;
        try {
            hotComment = gameTouserDao.hotComment(gameId,num);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return hotComment;
        }
        return hotComment;
    }
    /*根据List的关键字，对评论的模糊查询
    *对数组进行排列组合
    * 再进行数组的查询
    * 对比返回结果集的总数，返回max值的结果集
    * */
   public List<GameTouser> likeComment(Integer gameId,List<String> list,int num,List<Integer> intList){
       List<GameTouser> comment=null;
       int a=list.size();//关键字总数
       if(a<3||num>a){
           return null;
       }
       String[][] str=getPorfolio(list,num);//存储3个关键字的组合
       int[] big=new int[str.length];//定义各组大小的存储数组
       int i=0;
       for(String[] simple:str){//获取关键字组合的评论数量大小
           List<String> clist=new ArrayList<String>();//数组转换为list
           for(int begin=0;begin<num;begin++){
               clist.add(simple[begin]);
           }
           big[i]=gameTouserDao.likeCommentCount(gameId,clist);//获取评论数量
           i++;
           clist.clear();
       }
       int size=0;//记录最大的一组
       int ma=big[0];
       for (int j=0;j<str.length-1;j++){//对比评论数量，
           if(ma<big[j]){
               size=j;
               ma=big[j];
           }
       }
       intList.add(big[size]);//将最大评论数添加到intlist
       List<String> list1=new ArrayList<>();
       for(String s:str[size]) {//4.返回结果集
            list1.add(s);
       }
       try {
           comment=gameTouserDao.likeComment(gameId,list1);
           sqlSession.commit();
       }catch (Exception e){
           e.printStackTrace();
           sqlSession.rollback();
           return comment;
       }
        return comment;
   }
    //从m选n的算法，返回二维数组
    public static String[][] getPorfolio(List<String> number, int n){
        int m=number.size();//参数数组长度
        int l=1;            //关注数组长度标记
        for(int s=m;s>m-n;s--){//获取排列数组长度l
            l=l*s;
        }
        for(int z=n;z>1;z--){
            l=l/z;
        }
        String[][] rs=new String[l][n];//返回结果
        String[] str=new String[n];            //将第一种排列存入数组rs（即所有1都在左边的情况）
        for(int x=0;x<n;x++){
            str[x]=number.get(x);
        }
        rs[0]=str;
        int[] s=new int[m];//构造下标数组
        boolean flag=true;//循环开关
        int k=1;         //返回结果数组长度（自增长）
        for (int i=0;i<m;i++){//初始化构造下标数组
            if(i<n)
                s[i]=1;
            else
                s[i]=0;
        }
        do {
            flag=false;      //初始化flag
            int zerocount=0;  //10转换 01前的0的个数
            for(int i=0;i<m-1;i++){
                if(s[i]==0){//记录前0个数（非0即1），可以通过这个参数进行1的前移
                    zerocount++;
                }
                if(s[i]==1&&s[i+1]==0){//10变成0
                    s[i]=0;
                    s[i+1]=1;
                    flag=true;
                    for (int j=0;j<i;j++){
                        if (j<i-zerocount)
                            s[j]=1;
                        else
                            s[j]=0;
                    }
                    String[] returnStr=new String[n];
                    int aa=0;
                    for(int kk=0;kk<m;kk++){
                        if(s[kk]==1&&number.get(kk)!=null){
                            returnStr[aa]=number.get(kk);
                            aa++;
                        }
                    }
                    rs[k]=returnStr;
                    i=m;
                    k++;
                }
            }
        }while (flag==true);
        return rs;
    }

    //获取关键字里单个关键字评论数量前十的关键字
    public List<String> getDescTen(Integer gameId,List<String> list){
       int count=list.size();
       if(count<=10){
           return list;
       }
      int[] countArray=new int[count];//存储查询结果
       for(int i=0;i<count;i++){//获取查询结果
           try {
               countArray[i]=gameTouserDao.likeCommentOneCount(gameId,list.get(i));
               sqlSession.commit();
           }catch (Exception e){
               e.printStackTrace();
               sqlSession.rollback();
               return null;
           }
       }
       //查询结果排序
        int a=0;
       int[] b=new int[10];
        for(int i=0;i<10;i++){
            a=countArray[0];
            for (int j=0;j<count;j++){

                if(countArray[j]>a){
                    a=countArray[j];
                    b[i]=j;
                }
            }
            countArray[b[i]]=0;//最大置零
        }
        List<String> list1=new ArrayList<>();
        for(int i=0;i<10;i++){
            list1.add(list.get(b[i]));
        }
       return list1;
    }

}
