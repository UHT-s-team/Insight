package com.UHT.Insight.daoimpl;

import com.UHT.Insight.utils.FileUtils;
import com.UHT.Insight.utils.JsonUtils;
import org.junit.Test;

import java.util.Properties;

public class JsonTest {
    @Test
    public void read(){
      JsonUtils.getGameMap(FileUtils.reader("C:\\Users\\Develop\\Desktop\\新建文件夹\\game2.json"));
//      FileUtils.reader("E:/game3.json");
//      List<Map<String,Object>> list=JsonUtils.getListMap(FileUtils.reader("E:/demo/src/main/resources/data/game.json"));
    }
}
