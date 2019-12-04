package com.UHT.Insight.utils;

import com.UHT.Insight.daoImpl.GameDaoImpl;
import com.UHT.Insight.pojo.Game;
import com.alibaba.fastjson.JSONReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GameJson {
    private GameDaoImpl gameDao=new GameDaoImpl();
    public void gameJsonReaderByPath(String path){
        JSONReader reader = null;
        try {
           reader=new JSONReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Game> list=new ArrayList<>();
        reader.startArray();//第一层[]
        while (reader.hasNext()){
            reader.startObject();//[ ]里面的各个{}
            Game game=new Game();
            while (reader.hasNext()){
                //对里面元素的处理，集合元素
                //1.数组的处理
                String key=reader.readString();
                System.out.println("key: "+key);
                switch (key) {
                    case "游戏ID":
                        reader.startArray();
                        String id="0";
                        while (reader.hasNext()) {
                           id = reader.readString();//读取数组里的值,只有一个，不用特殊处理
                        }
                        game.setG_ID((Integer) Integer.parseInt((String) id));

                        reader.endArray();
                        break;
                    case "简介":
                        reader.startArray();
                        String breif="0";
                        while (reader.hasNext()) {
                            breif= reader.readString().trim();//读取数组里的值
                        }
                        game.setBREIF(breif);
                        reader.endArray();
                        break;
                    case "最近更新内容":
                        reader.startArray();
                        String recent="0";
                        while (reader.hasNext()) {
                            recent = reader.readString().trim();//读取数组里的值
                        }
                        game.setR_CONTENT(recent);
                        reader.endArray();
                        break;
                    case "评论数":
                        reader.startArray();
                        String r_number="0";
                        while (reader.hasNext()) {
                            r_number= reader.readString();//读取数组里的值
                        }
                        game.setR_NUMBER((Integer) Integer.parseInt((String)r_number));

                        reader.endArray();
                        break;
                    case "社区数":
                        reader.startArray();
                        String r_com="0";
                        while (reader.hasNext()) {
                            r_com= reader.readString();//读取数组里的值
                        }
                        game.setC_NUMBER((Integer) Integer.parseInt((String)r_com));
                        reader.endArray();
                        break;
                    case "类型标签":
                        reader.startArray();
                        String tablib="0";
                        String nnp=null;
                        while (reader.hasNext()) {
                           nnp= reader.readString().trim();//读取数组里的值
                            if(!nnp.isEmpty()){
                                if(tablib.equals("0")){
                                    tablib=nnp;
                                }else {
                                    tablib += nnp;
                                }
                            }
                        }
                        game.setT_TAGLTB(tablib);
                        reader.endArray();
                        break;
                    case "是否推荐":
                        reader.startArray();
                        String r_pu="否";
                        while (reader.hasNext()) {
                            r_pu = reader.readString();//读取数组里的值
                        }
                        game.setRECOMMENT(r_pu);
                        reader.endArray();
                        break;
                    case "游戏名称":
                        reader.startArray();
                        String gameName="0";
                        while (reader.hasNext()) {
                           gameName= reader.readString();//读取数组里的值
                        }
                        game.setG_NAME(gameName);
                        reader.endArray();
                        break;
                    case "图片":
                        reader.startArray();
                        String url="无";
                        while (reader.hasNext()) {
                            url= reader.readString();//读取数组里的值
                        }
                        game.setURL(url);
                        reader.endArray();
                        break;
                    case "厂商":
                        reader.startArray();
                        String create="";
                        String mmp=null;
                        while (reader.hasNext()) {
                            mmp=reader.readString();
                            if(!mmp.isEmpty()){
                                create+=mmp;
                            }
                        }
                        game.setVENDER(create);
                        reader.endArray();
                        break;
                    case "安装数":
                        reader.startArray();
                        String dowload="0";
                        String attention="0";
                        while (reader.hasNext()) {
                            dowload=reader.readString();
                            if(dowload.contains("人关注")){
                                attention=dowload.substring(0,dowload.length()-3).trim();
                                game.setATTENTION((Integer) Integer.parseInt((String)attention));
                            }else if(dowload.isEmpty()){
                                game.setATTENTION(0);
                            }

                            if(dowload.endsWith("人安装")){
                                dowload=dowload.substring(0,dowload.length()-3).trim();
                                game.setDOWNLOAD((Integer) Integer.parseInt((String) dowload));
                            }else  if(dowload.isEmpty()){
                                game.setDOWNLOAD(0);
                            }


                        }
                        reader.endArray();
                        break;
                    case "总评分":
                        reader.startArray();
                        String all="0";
                        while (reader.hasNext()) {
                            all= reader.readString();//读取数组里的值
                        }
                        game.setA_DRADE((float)Float.parseFloat((String)all));
                        reader.endArray();
                        break;
                     default: System.out.println("数据格式错误");
                }

            }
            list.add(game);
            if(list.size()>=1000){
                gameDao.saveGameList(list);
                list.clear();//清空
            }

            reader.endObject();//结束{}
        }
        gameDao.saveGameList(list);
        reader.endArray();//结束[]
    }

}
