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
                System.out.println((String)jsonObject.getString("社区数").trim().toString());
                treeNodes.put("评论数", (String)jsonObject.getString("评论数").trim());
                treeNodes.put("社区数", jsonObject.getString("社区数").trim());
                treeNodes.put("是否推荐", jsonObject.getString("是否推荐").trim());
                treeNodes.put("游戏名称", jsonObject.getString("游戏名称"));
                treeNodes.put("图片", jsonObject.getString("图片"));
                String str=null;
                JSONArray cArray = JSONArray.fromObject(jsonObject.getString("厂商"));
                for (Object ob : cArray) {
                    if(ob.toString()!=null) {
                        str += ob.toString() + ",";
                    }
                }
                treeNodes.put("厂商", str);
                treeNodes.put("安装数", jsonObject.getString("安装数").trim());
                treeNodes.put("关注数", jsonObject.getString("关注数").trim());
                String tablib = "";
                JSONArray tablibArray = JSONArray.fromObject(jsonObject.getString("类型标签"));
                for (Object ob : tablibArray) {
                    if (ob.toString() != null) {
                        tablib += ob.toString() + ",";
                    }
                }
                treeNodes.put("类型标签", tablib);
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
        Game game=new Game();
        GameDao gameDao=new GameDaoImpl();
        NumberFormat numberFormat=NumberFormat.getNumberInstance();
        try{
                game.setG_ID((Integer)Integer.parseInt((String)map.get("游戏ID").toString().trim()));
                game.setG_NAME((String)map.get("游戏名称").toString());
                game.setBREIF((String)map.get("简介").toString());
                game.setR_CONTENT((String)map.get("最近更新内容").toString());
                game.setR_NUMBER(Integer.parseInt((String)map.get("评论数").trim()));
                game.setC_NUMBER(Integer.parseInt((String)map.get("社区数").trim()));
                game.setVENDER((String)map.get("厂商").toString());
                game.setA_DRADE(Float.parseFloat(map.get("总评分").toString()));
                game.setT_TAGLTB((String)map.get("类型标签").toString());
                game.setRECOMMENT((String)map.get("是否推荐").toString());
                game.setDOWNLOAD(Integer.parseInt(map.get("安装数").toString().trim()));
                game.setATTENTION(Integer.parseInt(map.get("关注数").toString().trim()));
                game.setURL((String)map.get("图片").toString());
                gameDao.saveGame(game);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //GameTouser的数据插入
    public static void insertGameTouser(Map<String,String> map) {
        GameTouser gameTouser =new GameTouser();
        GameTouserDao gameTouserDao = new GameTouserDaoImpl();

        try {
                //获取map对应属性的String，并将String类型转换为各种类型
                gameTouser.setU_ID(Integer.parseInt((String)map.get("用户ID").toString().trim()));        //TapTap用户ID
                gameTouser.setG_ID(Integer.parseInt(map.get("游戏ID").toString().trim()));        //对应游戏ID
                gameTouser.setU_NAME((String)map.get("用户名").toString());       //用户名称
                Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(map.get("评论时间").toString());//发布时间
                System.out.println(date);
                gameTouser.setI_TIME(date);
                System.out.println(gameTouser.getI_TIME());
                gameTouser.setD_START(Integer.parseInt(map.get("评分").toString().trim()));      //评分星级
                gameTouser.setG_TIME((String)(map.get("游戏时间").toString()));       //游戏时长
                gameTouser.setD_CONTENT((String)map.get("评论").toString());    //评论内容
                gameTouser.setG_EQUTPTMENT((String)map.get("设备").toString()); //游戏设备
                gameTouser.setD_HAPPY(Integer.parseInt(map.get("欢乐数").toString().trim()));     //欢乐数
                gameTouser.setD_AGRESS(Integer.parseInt(map.get("欢乐数").toString().trim()));    //欢乐数
                gameTouser.setD_DISAGRESS(Integer.parseInt(map.get("点踩数").toString().trim())); //点踩数
                gameTouser.setREPLY(Integer.parseInt(map.get("回复数").toString().trim()));       //回复数
                gameTouserDao.saveGameTouser(gameTouser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}