package com.UHT.Insight.daoImpl;

import com.UHT.Insight.utils.GameJson;
import com.UHT.Insight.utils.GameToUserJson;
import com.UHT.Insight.utils.TapUserAndRecentPlayJson;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

public class JsonTest {
    @Test
    public void readBigGameFile(){//读取game.json大文件
        Long start=System.currentTimeMillis();
        GameJson json=new GameJson();
        json.gameJsonReaderByPath("C:\\Users\\Develop\\Desktop\\新建文件夹\\user\\game.json");
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

    @Test
    @Transactional
    public void readBigGameToUserFile(){//读取gametosuer.json大文件
        Long start=System.currentTimeMillis();
        GameToUserJson gameToUserJson=new GameToUserJson();
        gameToUserJson.gameToUserJsonReaderByPath("C:\\Users\\ASUS\\Desktop\\130651.json");
        Long end=System.currentTimeMillis();
        System.out.println("总耗时:"+(end-start)+"微秒");
    }
}
