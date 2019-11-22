package com.UHT.Insight.daoimpl;

import com.UHT.Insight.dto.PeopleDTO;
import com.UHT.Insight.utils.FileUtils;
import com.UHT.Insight.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonTest {
    @Test
    public void read() {
//        String s=FileUtils.reader("D:/学习/代码/JavaWeb/Insight/src/main/resources/static/json/game4.json");
//        JsonUtils.getGameMap(s);
        //System.out.println("C:\\Users\\Develop\\Desktop\\新建文件夹\\game1" + 1 + ".json");
//        BufferedReader reader = null;
//        try {
//            String file="D:/学习/代码/JavaWeb/Insight/src/main/resources/static/json/game4.json";
//            reader = new BufferedReader(new FileReader(file));
//            Gson gson = new GsonBuilder().create();
//            PeopleDTO[] people = gson.fromJson(reader, PeopleDTO[].class);
//            System.out.println("Object mode: " + people[0]);
//        } catch (FileNotFoundException ex) { }
        //15,16,22
//        for (int i = 23; i <= 33; i++) {
//            String filePath = "D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\resources\\JsonFile\\game" + i + ".json";
//            JsonUtils.getGameMap(FileUtils.reader(filePath));
//        }
//              JsonUtils.getGameMap(FileUtils.reader("D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\resources\\JsonFile\\game22.json"));
        JsonUtils.getGameMap(FileUtils.reader("F:\\Insight\\src\\main\\resources\\JsonFile\\game22.json"));
    }
}
