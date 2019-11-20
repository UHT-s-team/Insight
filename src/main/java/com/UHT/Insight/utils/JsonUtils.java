package com.UHT.Insight.utils;

import com.UHT.Insight.dao.*;
import com.UHT.Insight.daoImpl.*;
import com.UHT.Insight.pojo.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/*
对json数据的解析和批量插入
 */
public class JsonUtils {
    //对game和gametouser的插入
    public static void  getGameMap(String txtStr) {
        JSONArray json = JSONArray.fromObject(txtStr.toString());
        String G_ID = null;
        //循环遍历所有json子串
        for (Object object : json) {
            JSONObject jsonObject = JSONObject.fromObject(object);
            Map<String, String> treeNodes = new HashMap<String, String>();
            if(jsonObject.has("游戏ID")) {
                treeNodes.put("游戏ID", jsonObject.getString("游戏ID"));
                G_ID = jsonObject.getString("游戏ID");
                treeNodes.put("简介", jsonObject.getString("简介"));
                treeNodes.put("最近更新内容", jsonObject.getString("最近更新内容"));
                String str=null;
                System.out.println(str=(String)jsonObject.getString("社区数").trim().toString());
                treeNodes.put("评论数", (String)jsonObject.getString("评论数").trim());
                treeNodes.put("社区数", jsonObject.getString("社区数").trim());
                treeNodes.put("是否推荐", jsonObject.getString("是否推荐").trim());
                treeNodes.put("游戏名称", jsonObject.getString("游戏名称"));
                treeNodes.put("图片", jsonObject.getString("图片"));
                treeNodes.put("厂商", jsonObject.getString("厂商"));
                treeNodes.put("安装数", jsonObject.getString("安装数").trim());
                treeNodes.put("关注数", jsonObject.getString("关注数").trim());
                String tablib = "";
                JSONArray tablibArray = JSONArray.fromObject(jsonObject.getString("类型标签"));
                for (Object ob : tablibArray) {
                    tablib += ob.toString() + ",";
                    treeNodes.put("类型标签", tablib);
                }
                treeNodes.put("总评分", jsonObject.getString("总评分"));
                System.out.println(treeNodes);
                insertGame(treeNodes);
            }
            if(jsonObject.has("用户名")) {
                treeNodes.put("游戏ID", G_ID);
                treeNodes.put("用户名", jsonObject.getString("用户名"));
                treeNodes.put("用户ID", (String)jsonObject.getString("用户ID").toString().trim());
                treeNodes.put("评论", jsonObject.getString("评论"));
                treeNodes.put("评论时间", jsonObject.getString("评论时间"));
                treeNodes.put("评分", jsonObject.getString("评分"));
                treeNodes.put("设备", jsonObject.getString("设备"));
                treeNodes.put("游戏时间", jsonObject.getString("游戏时间"));
                treeNodes.put("欢乐数", jsonObject.getString("欢乐数").trim());
                treeNodes.put("点赞数", jsonObject.getString("点赞数").trim());
                treeNodes.put("点踩数", jsonObject.getString("点踩数").trim());
                treeNodes.put("回复数", jsonObject.getString("回复数").trim());
                System.out.println(treeNodes);
                insertGameTouser(treeNodes);
            }
            System.out.println(treeNodes);
        }

    }


    /*
    将不同表的结果存入数据库：
     */
    //Game的数据插入
    public static void insertGame(Map<String,String> map) {
        Integer G_ID;       //游戏id
        String G_NAME;      //游戏名称
        String BREIF;       //简介
        String R_CONTENT;   //最近更新内容
        Integer R_NUMBER;   //评论数量
        Integer C_NUMBER;   //社区数量
        String VENDER;      //厂商
        Float A_DRADE;      //总评分
        String T_TAGLTB;    //类型标签
        String RECOMMENT;  //是否推荐，
        Integer DOWNLOAD;   //下载次数
        Integer ATTENTION;  //关注数
        String URL;         //图片路径
        Game game=new Game();
        GameDao gameDao=new GameDaoImpl();
        NumberFormat numberFormat=NumberFormat.getNumberInstance();
        try{
                game.setG_ID(G_ID=(Integer)Integer.parseInt((String)map.get("游戏ID").toString().trim()));
                game.setG_NAME(G_NAME=(String)map.get("游戏名称").toString());
                game.setBREIF(BREIF=(String)map.get("简介").toString());
                game.setR_CONTENT(R_CONTENT=(String)map.get("最近更新内容").toString());
                game.setR_NUMBER(R_NUMBER=Integer.parseInt((String)map.get("评论数").trim()));
                game.setC_NUMBER(C_NUMBER=Integer.parseInt((String)map.get("社区数").trim()));
                game.setVENDER(VENDER=(String)map.get("厂商").toString());
                game.setA_DRADE(A_DRADE=Float.parseFloat(map.get("总评分").toString()));
                game.setT_TAGLTB(T_TAGLTB=(String)map.get("类型标签").toString());
                game.setRECOMMENT(RECOMMENT=(String)map.get("是否推荐").toString());
                game.setDOWNLOAD(DOWNLOAD=Integer.parseInt(map.get("安装数").toString().trim()));
                game.setATTENTION(ATTENTION=Integer.parseInt(map.get("关注数").toString().trim()));
                game.setURL(URL=(String)map.get("图片").toString());
                gameDao.saveGame(game);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //GameTouser的数据插入
    public static void insertGameTouser(Map<String,String> map) {
        Integer U_ID;        //TapTap用户ID
        Integer G_ID;        //对应游戏ID
        String U_NAME;       //用户名称
        Date I_TIME;         //发布时间
        Float D_START;       //评分星级
        String G_TIME;        //游戏时长
        String D_CONTENT;    //评论内容
        String G_EQUTPTMENT; //游戏设备
        Integer D_HAPPY;     //欢乐数
        Integer D_AGRESS;    //点赞数
        Integer D_DISAGRESS; //点踩数
        Integer REPLY;       //回复数
        GameTouser gameTouser =new GameTouser();
        GameTouserDao gameTouserDao = new GameTouserDaoImpl();

        try {
                //获取map对应属性的String，并将String类型转换为各种类型
                gameTouser.setU_ID(U_ID=Integer.parseInt((String)map.get("用户ID").toString().trim()));        //TapTap用户ID
                gameTouser.setG_ID(G_ID=Integer.parseInt(map.get("游戏ID").toString().trim()));        //对应游戏ID
                gameTouser.setU_NAME(U_NAME=(String)map.get("用户名").toString());       //用户名称
                Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(map.get("评论时间").toString());//发布时间
                System.out.println(gameTouser.getI_TIME());
                gameTouser.setD_START(D_START=Float.parseFloat(map.get("评分").toString().trim()));      //评分星级
                gameTouser.setG_TIME(G_TIME=(String)(map.get("游戏时间").toString()));       //游戏时长
                gameTouser.setD_CONTENT(D_CONTENT=(String)map.get("评论").toString());    //评论内容
                gameTouser.setG_EQUTPTMENT(G_EQUTPTMENT=(String)map.get("设备").toString()); //游戏设备
                gameTouser.setD_HAPPY(D_HAPPY=Integer.parseInt(map.get("欢乐数").toString().trim()));     //欢乐数
                gameTouser.setD_AGRESS(D_AGRESS=Integer.parseInt(map.get("欢乐数").toString().trim()));    //欢乐数
                gameTouser.setD_DISAGRESS(D_DISAGRESS=Integer.parseInt(map.get("点踩数").toString().trim())); //点踩数
                gameTouser.setREPLY(REPLY=Integer.parseInt(map.get("回复数").toString().trim()));       //回复数
                gameTouserDao.saveGameTouser(gameTouser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //TapUser的数据插入
    public int insertTapUser(List<Map<String, Object>> list) {
        Integer U_ID;         //用户Id
        String U_NAME;        //当前用户名
        Integer FANS;       //粉丝数
        Integer ATTENTION;     //关注数
        Integer COLLECT;      //收藏数
        Integer PLAY;    //玩过游戏数
        Integer L_PLAY;      //玩得最久游戏数
        Integer APPRAISE;         //评价数
        Float G_WEIGHT;       //评分权重
        int i=0;
        TapUser tapUser=new TapUser();
        TapUserDao tapUserDao=new TapUserDaoImpl();
        try{
            for (Map map:list) {
                tapUser.setU_ID(U_ID=Integer.parseInt(map.get("").toString()));
                tapUser.setU_NAME(U_NAME=(String)map.get("").toString());
                tapUser.setATTENTION(ATTENTION=Integer.parseInt(map.get("").toString()));
                tapUser.setG_WEIGHT(0.0f);
                tapUserDao.SaveTapUser(tapUser);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}