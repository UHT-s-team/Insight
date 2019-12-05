package com.UHT.Insight.daoimpl;

import com.UHT.Insight.dto.GameJson;
import com.UHT.Insight.utils.TapUserAndRecentPlayJson;
import org.junit.Test;

public class JsonTest {
    @Test
    public void read() {
        Long start=System.currentTimeMillis();
        for (int i = 11; i <= 33; i++) {
            try {
                String filePath = "F:\\Insight\\src\\main\\resources\\JsonFile\\game" + i + ".json";
//            String filePath = "D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\resources\\JsonFile\\game" + i + ".json";
//                JsonUtils.getGameMap(FileUtils.reader(filePath));
            }catch (Exception e){
                e.printStackTrace();
            }
            Long end=System.currentTimeMillis();
            System.out.println("到第"+i+"文件时耗时:"+(end-start)+"微秒");
        }
        Long end=System.currentTimeMillis();
        System.out.println("总耗时:"+(end-start)+"微秒");
//        JsonUtils.getGameMap(FileUtils.reader("D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\resources\\JsonFile\\game22.json"));

//        Long start=System.currentTimeMillis();
//        JsonUtils.getGameMap(FileUtils.reader("F:\\Insight\\src\\main\\resources\\JsonFile\\game22.json"));
//        Long end=System.currentTimeMillis();
//        System.out.println("耗时:"+(end-start)+"微秒");
    }
    @Test
    public void readBigGameFile(){//读取game.json大文件
        Long start=System.currentTimeMillis();
        GameJson json=new GameJson();
        json.gameJsonReaderByPath("D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\resources\\JsonFile\\game.json");
        Long end=System.currentTimeMillis();
        System.out.println("总耗时:"+(end-start)+"微秒");
    }
    @Test
    public void readBigUserFile(){//读user.json大文件
        Long start=System.currentTimeMillis();
        TapUserAndRecentPlayJson json=new TapUserAndRecentPlayJson();
        json.readTUARPJson("C:\\Users\\Develop\\Desktop\\新建文件夹\\user\\user.json");
        Long end=System.currentTimeMillis();
        System.out.println("总耗时:"+(end-start)+"微秒");
    }
}
