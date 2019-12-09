package com.UHT.Insight.utils;

import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.pojo.GameTouser;
import com.alibaba.fastjson.JSONReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameToUserJson {
    private GameToUserDaoImpl gameToUserDao=new GameToUserDaoImpl();
    public void gameToUserJsonReaderByPath(String path){
        JSONReader reader = null;
        try {
            reader=new JSONReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<GameTouser> list=new ArrayList<>();
        reader.startArray();//第一层[]
        while (reader.hasNext()) {
            reader.startObject();//[]里面的各个{}
            GameTouser gameTouser=new GameTouser();
            while (reader.hasNext()) {
                //对里面元素的处理，集合元素
                //1.数组的处理

                String key = reader.readString();
                System.out.println("key: " + key);
                switch (key) {
                    case "评论时间":
                        reader.startArray();
                       String dateString=null;
                        while (reader.hasNext()) {
                           dateString=reader.readString();
                        }
                        if(!dateString.isEmpty()){
                            try {
                                Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
                                gameTouser.setI_TIME(date);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        reader.endArray();
                        break;
                    case "游戏ID":
                        String gId=reader.readString();
                        if (!gId.isEmpty()){
                            gameTouser.setG_ID(Integer.parseInt(gId));
                        }else {
                            gameTouser.setG_ID(0000);
                        }
                        break;
                    case "游戏时间":

                        String gTime=null;
                            gTime=reader.readString();
                        if (gTime.length()<=2){
                            gameTouser.setG_TIME("0");
                        }else {
                            gTime=gTime.substring(2,gTime.length()-2);
                            gameTouser.setG_TIME(gTime);
                        }
                        break;
                    case "点踩数":
                        String disagress=null;
                        disagress=reader.readString();
                        disagress=disagress.replace("[\"","");
                        disagress=disagress.replace("\"]","");
                        if(disagress.isEmpty()){
                            gameTouser.setD_DISAGRESS(0);
                        }else {
                            gameTouser.setD_DISAGRESS(Integer.parseInt(disagress));
                        }
                        break;
                    case "评分":
                        Integer number=0;
                        number=reader.readInteger();
                        gameTouser.setD_START(number);
                        break;
                    case "评论":
                        reader.startArray();
                        String content=null;
                        while (reader.hasNext()) {
                            content=reader.readString();
                        }
                        if (content.isEmpty()){
                            gameTouser.setD_CONTENT("无");
                        }else{
                            gameTouser.setD_CONTENT(content);
                        }
                        reader.endArray();
                        break;
                    case "欢乐数":
                        String happy=reader.readString();
                        happy=happy.replace("[\"","");
                        happy=happy.replace("\"]","");
                        gameTouser.setD_HAPPY(Integer.parseInt(happy));
                        break;
                    case "设备":
                        String equ=null;
                        equ=reader.readString();
                        equ=equ.replace("[\"","");
                        equ=equ.replace("\"]","");
                        if (equ.isEmpty()){
                            gameTouser.setG_EQUTPTMENT("无");
                        }else{
                            gameTouser.setG_EQUTPTMENT(equ);
                        }
                        break;
                    case "点赞数":
                        String agress=reader.readString();
                        agress=agress.replace("[","");
                        agress=agress.replace("]","");
                        if(agress.isEmpty()){
                            gameTouser.setD_AGRESS(0);
                        }else {
                            gameTouser.setD_AGRESS(Integer.parseInt(agress));
                        }
                        break;
                    case "用户名":
                        reader.startArray();
                        String userName=null;
                        while (reader.hasNext()) {
                            userName=reader.readString();
                        }
                        if (userName.isEmpty()){
                            gameTouser.setU_NAME("无");
                        }else{
                            gameTouser.setU_NAME(userName);
                        }
                        reader.endArray();
                        break;
                    case "回复数":
                        reader.startArray();
                        String reply=null;
                        while (reader.hasNext()) {
                            reply=reader.readString();
                        }
                        if (reply.equals("回复")){
                            gameTouser.setREPLY(0);
                        }else{
                            reply=reply.substring(2,reply.length()).trim();
                            if((!reply.isEmpty())&&reply.matches("^[0-9]*$")){
                                gameTouser.setREPLY(Integer.parseInt(reply));
                            }else{
                                gameTouser.setREPLY(0);
                            }
                        }
                        reader.endArray();
                        break;
                    case "用户ID":
                        reader.startArray();
                        String uId=null;
                        while (reader.hasNext()) {
                            uId=reader.readString();
                        }
                        if (uId.isEmpty()){
                            gameTouser.setU_ID(0 );
                        }else{
                            gameTouser.setU_ID(Integer.parseInt(uId));
                        }
                        reader.endArray();
                }

            }
            list.add(gameTouser);
            if(list.size()>1000){
                gameToUserDao.addGameList(list);
                list.clear();
            }
            reader.endObject();
        }
        gameToUserDao.addGameList(list);
        reader.endArray();
    }
}
