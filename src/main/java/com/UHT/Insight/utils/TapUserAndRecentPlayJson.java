package com.UHT.Insight.utils;

import com.UHT.Insight.daoImpl.RecentPlayDaoImpl;
import com.UHT.Insight.daoImpl.TapUserDaoImpl;
import com.UHT.Insight.pojo.RecentPlay;
import com.UHT.Insight.pojo.TapUser;
import com.alibaba.fastjson.JSONReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TapUserAndRecentPlayJson {
    private TapUserDaoImpl tapUserDao=new TapUserDaoImpl();
    private RecentPlayDaoImpl recentPlayDao=new RecentPlayDaoImpl();
    public void readTUARPJson(String path){
        JSONReader reader = null;
        try {
            reader=new JSONReader(new FileReader(path));//开启读取流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reader.startArray();//进入第一层[]
//        reader.startObject();
        while (reader.hasNext()){
            RecentPlay recentPlay=new RecentPlay();
            TapUser tapUser=new TapUser();
            List<RecentPlay> playList=new ArrayList<>();
            List<TapUser> tapList=new ArrayList<>();
            reader.startObject();//[]里面的各个{}
                while (reader.hasNext()){//读取各key值
                    String key=reader.readString();
                    System.out.println("key: "+key);
                    switch (key){
                        case "用户名":
                            reader.startArray();//用户名数组的读取
                            String userName="0";
                            while (reader.hasNext()) {
                                userName=reader.readString();
                            }
                            tapUser.setU_NAME(userName);
                            reader.endArray();
                            break;
                        case "用户id":
                             reader.startArray();
                             String id="0";
                             while (reader.hasNext()){
                                 id=reader.readString();
                                 if(id.startsWith("ID:")){
                                     id=id.substring(3,id.length());
                                 }
                             }
                            tapUser.setU_ID((Integer)Integer.parseInt(id));
                             reader.endArray();
                            break;
                        case "签名":
                            reader.readString();//字符串直接读
                            break;
                        case "收到的赞":
                                reader.readString();
                            break;
                        case "收到的欢乐":
                                System.out.println(reader.readString());
                            break;
                        case "粉丝数":
                            reader.startArray();
                            String fans="0";
                            while (reader.hasNext()){
                                fans=reader.readString();
                            }
                            tapUser.setFANS((Integer)Integer.parseInt(fans));
                            reader.endArray();
                            break;
                        case "关注数":
                            reader.startArray();
                            String attention="0";
                            while (reader.hasNext()){
                               attention=reader.readString();
                            }
                            tapUser.setATTENTION((Integer)Integer.parseInt(attention));
                            reader.endArray();
                            break;
                        case "收藏数":
                            reader.startArray();
                            String col="0";
                            while (reader.hasNext()){
                                col=reader.readString();
                            }
                            tapUser.setCOLLECT((Integer)Integer.parseInt(col));
                            reader.endArray();
                            break;
                        case "玩过游戏数":
                            reader.startArray();
                            String play="0";
                            while (reader.hasNext()){
                                play=reader.readString();
                            }
                            tapUser.setPLAY((Integer)Integer.parseInt(play));
                            reader.endArray();
                            break;
                        case "评价数":
                            reader.startArray();
                            String appr="0";
                            while (reader.hasNext()){
                                appr=reader.readString();
                            }
                            tapUser.setFANS((Integer)Integer.parseInt(appr));
                            reader.endArray();
                            break;
                        case "帖子数":
                                reader.readString();
                            break;
                        case "回复数":
                                reader.readString();
                            break;
                        case "玩过的游戏":
                            reader.startArray();//去掉[
                            recentPlay.setU_ID(tapUser.getU_ID());
                            while (reader.hasNext()){//读取数组
                                reader.startObject();
                                while (reader.hasNext()){
                                    String key1=reader.readString();
                                    System.out.println("key: "+key1);
                                    switch (key1){
                                        case "游戏名称":
                                            reader.startArray();
                                            String gameName="";
                                            String mmp="";
                                            while (reader.hasNext()){
                                                mmp=reader.readString();
                                                if(!mmp.isEmpty()&&gameName.isEmpty()){
                                                    gameName+=mmp+",";
                                                }else if (gameName.isEmpty()){
                                                    gameName=mmp;
                                                }
                                            }
                                            if(gameName.endsWith(",")) {
                                                gameName.substring(0, gameName.length() - 1);
                                            }
                                            recentPlay.setG_NAME(gameName);
                                            reader.endArray();
                                            break;
                                        case "游戏评分":
                                            reader.startArray();
                                            String number="0";
                                            while (reader.hasNext()){
                                                number=reader.readString();
                                            }
                                            if(number.equals("页面已失效")){
                                                recentPlay.setG_NUMBER(0f);
                                                reader.endArray();
                                                break;
                                            }
                                            if(number.equals("Not enough ratings")){
                                                recentPlay.setG_NUMBER(0f);
                                                reader.endArray();
                                                break;
                                            }
                                            recentPlay.setG_NUMBER((Float)Float.parseFloat(number));
                                            reader.endArray();
                                            break;
                                        case "游戏类型":
                                            reader.startArray();
                                            String type="";
                                            String nnp="";
                                            while (reader.hasNext()){
                                                nnp=reader.readString();
                                                if (type.isEmpty()&&!nnp.isEmpty()){
                                                    type=nnp;
                                                }else if (!nnp.isEmpty()){
                                                    type+=nnp;
                                                }
                                            }
                                            recentPlay.setT_TAGLIB(type);
                                            reader.endArray();
                                            break;
                                        case "游戏时长":
                                            String time="无";
                                            time = reader.readString();
                                            if(!time.equals("0")) {
                                                time.substring(2, time.length() - 2);
                                            }
                                            recentPlay.setG_TIME(time);
                                            break;
                                        default:break;
                                    }
                                }
                                reader.endObject();
                            }
                            playList.add(recentPlay);
                            reader.endArray();
                            break;
                        default:break;
                    }
                    tapList.add(tapUser);
                    if(tapList.size()>1000){
                        tapUserDao.SaveTapUserList(tapList);
                        tapList.clear();
                    }
                    if(playList.size()>100){
                        recentPlayDao.saveRecentPlayList(playList);
                        playList.clear();
                    }

                }
            tapUserDao.SaveTapUserList(tapList);
            recentPlayDao.saveRecentPlayList(playList);
            reader.endObject();
        }
//         reader.endObject();
        reader.endArray();
    }
}
