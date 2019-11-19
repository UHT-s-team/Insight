package com.UHT.Insight.daoimpl;

import com.UHT.Insight.utils.FileUtils;
import com.UHT.Insight.utils.JsonUtils;
import org.junit.Test;

public class JsonTest {
    @Test
    public void read(){
      JsonUtils.getGameMap(FileUtils.reader("E:/game3.json"));
      //FileUtils.reader("E:/game3.json");
//      List<Map<String,Object>> list=JsonUtils.getListMap(FileUtils.reader("E:/demo/src/main/resources/data/game.json"));
    }
}
