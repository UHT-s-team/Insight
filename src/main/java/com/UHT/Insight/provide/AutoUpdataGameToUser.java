package com.UHT.Insight.provide;

import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.pojo.CompareUser;
import com.UHT.Insight.service.ScrapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutoUpdataGameToUser {

    private ScrapyService scrapyService=new ScrapyService();

    private GameToUserDaoImpl gameToUserDao = new GameToUserDaoImpl();

    public void UpdataGameToUser(int gameId) {
        String path = null;
        if (isWindows()) {
            //判断运行在linux服务器上还是windows本机
            path = "D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\java\\com\\UHT\\Insight\\Python_scrapy\\scrapy";
        } else {
            //运行在linux服务器上
            path = "/root/Insight/src/main/java/com/UHT/Insight/Python_scrapy/scrapy";
        }
        gameToUserDao.deleteGameTouserByGameId(gameId);
        scrapyService.buildScrapyStartFile(gameId, "tap", path);
        scrapyService.runScrapyStartFile(gameId, path);
    }

    @Scheduled(cron = "0 */10 * * * ?")//自动随机更新游戏
    public void UpdateGameToUser() {
        int gameId;
        gameId = (int) (Math.random() * 179428);
        String path = null;
        if (isWindows()) {
            //判断运行在linux服务器上还是windows本机
            path = "D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\java\\com\\UHT\\Insight\\Python_scrapy\\scrapy";
        } else {
            //运行在linux服务器上
            path = "/root/Insight/src/main/java/com/UHT/Insight/Python_scrapy/scrapy";
        }
        gameToUserDao.deleteGameTouserByGameId(gameId);
        scrapyService.buildScrapyStartFile(gameId, "tap", path);
        scrapyService.runScrapyStartFile(gameId, path);
    }

    @Scheduled(cron = "0 45 18 1 * ?")//更新指定游戏
    public void UpdateTopGameToUser() {
        int[] a = {
                180772, 183496, 143110, 85108, 2301, 10056, 136112, 70056, 43639, 70253, 58881, 34751, 182906, 144535, 137515, 67396, 130651, 71331, 134346, 50500, 58885, 2247, 174842, 149252, 12492, 181394, 10505, 61620, 57520, 213
                , 180772, 183496, 143110, 136112, 144535, 182906, 137515, 149252, 181394, 57520, 182499, 60908, 183462, 182901, 169161, 182914, 84231, 182840, 167322, 153730, 180101, 182882, 174654, 182819, 182556, 181241, 181267, 175587, 180285, 182915
                , 183526, 72799, 162615, 158451, 45213, 39310, 172652, 168332, 91863, 163885, 175417, 55881, 183497, 133336, 154361, 179882, 166951, 182279, 143069, 183466, 183445, 167133, 179371, 139301, 181408, 137520, 180048, 182785, 182555
                , 11190, 153415, 65333, 60809, 174205, 155402, 136830, 13969, 135162, 12547, 70794, 59622, 176077, 14741, 63121, 157573, 62747, 31072, 39224, 43970, 72303, 9811, 175614, 43873, 39836, 176076, 72314, 166642, 33973, 72825
                , 2301, 180772, 70253, 10056, 70056, 136112, 143110, 34751, 137515, 2247, 58885, 130651, 61620, 213, 147488, 12492, 43639, 67396, 58881, 12982, 85108, 158690, 55618, 2318, 31597, 10505, 79072, 50500, 79068, 73024
        };
        String path = null;
        if (isWindows()) {
            //判断运行在linux服务器上还是windows本机
            path = "D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\java\\com\\UHT\\Insight\\Python_scrapy\\scrapy";
        } else {
            //运行在linux服务器上
            path = "/root/Insight/src/main/java/com/UHT/Insight/Python_scrapy/scrapy";
        }
        for (int gameId:a) {
            gameToUserDao.deleteGameTouserByGameId(gameId);
            scrapyService.buildScrapyStartFile(gameId, "tap", path);
            scrapyService.runScrapyStartFile(gameId, path);
        }
    }

    //@Scheduled(cron = "0 45 18 1 * ?")
    // 根据gametouser表更新Tapuser表
    public void UpdateTapUser() {
        List<CompareUser> compareUsers = gameToUserDao.CompareTapAndGameUser();
        String path = null;
        if (isWindows()) {
            //判断运行在linux服务器上还是windows本机
            path = "D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\java\\com\\UHT\\Insight\\Python_scrapy\\scrapy";
        } else {
            //运行在linux服务器上
            path = "/root/Insight/src/main/java/com/UHT/Insight/Python_scrapy/scrapy";
        }
//        CompareUser compareUser=compareUsers.get(0);
        for (CompareUser compareUser:compareUsers) {
            scrapyService.buildScrapyStartFile(compareUser.getU_ID(), "user", path);
            scrapyService.runScrapyStartFile(compareUser.getU_ID(), path);
        }
    }

    public boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
}
