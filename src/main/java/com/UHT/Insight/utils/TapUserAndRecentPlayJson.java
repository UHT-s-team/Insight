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
                                     id=id.replace("ID:","");
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
                            fans.replace("[","");
                            fans.replace("]","");
                            fans.replace("\"","");
                            tapUser.setFANS((Integer)Integer.parseInt(fans));
                            reader.endArray();
                            break;
                        case "关注数":
                            reader.startArray();
                            String attention="0";
                            while (reader.hasNext()){
                               attention=reader.readString();
                            }
                            attention.replace("[","");
                            attention.replace("]","");
                            attention.replace("\"","");
                            tapUser.setATTENTION((Integer)Integer.parseInt(attention));
                            reader.endArray();
                            break;
                        case "收藏数":
                            String col="0";
                            col=reader.readString();
                            col=col.replace("[\"","");
                            col=col.replace("\"]","");
                            if(col.isEmpty()){
                                tapUser.setCOLLECT(0);
                            }else {
                                tapUser.setCOLLECT((Integer) Integer.parseInt(col));
                            }
                            break;
                        case "玩过游戏数":
                            String play="0";
                            play=reader.readString();
                            play.replace("[","");
                            play.replace("]","");
                            play.replace("\"","");
                            if(play.isEmpty()){
                                tapUser.setPLAY(0);
                            }else if(play.matches("^[0-9]*$")) {
                                tapUser.setPLAY((Integer) Integer.parseInt(play));
                            }else {
                                tapUser.setPLAY(0);
                            }
                            break;
                        case "评价数":
                            String appr="0";
                            appr=reader.readString();
                            appr=appr.replace("[","");
                            appr=appr.replace("]","");
                            appr=appr.replace("\"","");
                            if(appr.isEmpty()){
                                tapUser.setFANS(0);
                            }else {
                                tapUser.setFANS((Integer) Integer.parseInt(appr));
                            }
                            break;
                        case "帖子数":
                                reader.readString();
                            break;
                        case "回复数":
                                reader.readString();
                            break;
                        case "玩过的游戏":
                            reader.readString();
//                            reader.startArray();//去掉[
//                            recentPlay.setU_ID(tapUser.getU_ID());
//                            while (reader.hasNext()){//读取数组
//                                reader.startObject();
//                                while (reader.hasNext()){
//                                    String key1=reader.readString();
//                                    System.out.println("key: "+key1);
//                                    switch (key1){
//                                        case "游戏名称":
//                                            reader.startArray();
//                                            String gameName="";
//                                            String mmp="";
//                                            while (reader.hasNext()){
//                                                mmp=reader.readString();
//                                                if(!mmp.isEmpty()&&gameName.isEmpty()){
//                                                    gameName+=mmp+",";
//                                                }else if (gameName.isEmpty()){
//                                                    gameName=mmp;
//                                                }
//                                            }
//                                            if(gameName.endsWith(",")) {
//                                                gameName.substring(0, gameName.length() - 1);
//                                            }
//                                            recentPlay.setG_NAME(gameName);
//                                            reader.endArray();
//                                            break;
//                                        case "游戏评分":
//                                            reader.startArray();
//                                            String number="0";
//                                            while (reader.hasNext()){
//                                                number=reader.readString();
//                                            }
//                                            number=number.replace("页面已失效","");
//                                            number=number.replace("Not enough ratings","");
//                                           if(number.isEmpty()){
//                                               recentPlay.setG_NUMBER(0f);
//                                           }else if(number.matches("^[0-9]*$")) {
//                                               recentPlay.setG_NUMBER((Float) Float.parseFloat(number));
//                                           }else {
//                                               recentPlay.setG_NUMBER(0f);
//                                           }
//                                            reader.endArray();
//                                            break;
//                                        case "游戏类型":
//                                            reader.startArray();
//                                            String type="";
//                                            String nnp="";
//                                            while (reader.hasNext()){
//                                                nnp=reader.readString();
//                                                if (type.isEmpty()&&!nnp.isEmpty()){
//                                                    type=nnp;
//                                                }else if (!nnp.isEmpty()){
//                                                    type+=nnp;
//                                                }
//                                            }
//                                            recentPlay.setT_TAGLIB(type);
//                                            reader.endArray();
//                                            break;
//                                        case "游戏时长":
//                                            String time="无";
//                                            time = reader.readString();
//                                            time=time.replace("[\"","");
//                                            time=time.replace("\"]","");
//                                            if(time.isEmpty()){
//                                                recentPlay.setG_TIME("无");
//                                            }else {
//                                                recentPlay.setG_TIME(time);
//                                            }
//
//                                            break;
//                                        default:break;
//                                    }
//                                }
//                                reader.endObject();
//                            }
//                            playList.add(recentPlay);
//                            reader.endArray();
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
