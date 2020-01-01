package com.UHT.Insight.provide;

import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.service.ScrapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutoUpdataGameToUser {

    @Autowired
    private ScrapyService scrapyService;

    private GameToUserDaoImpl gameToUserDao=new GameToUserDaoImpl();


    public void UpdataGameToUser(int gameId){
        String path=null;
        if(isWindows()){
            //判断运行在linux服务器上还是windows本机
            path="D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\java\\com\\UHT\\Insight\\Python_scrapy\\scrapy";
        }else {
            //运行在linux服务器上
            path="/root/Insight/src/main/java/com/UHT/Insight/Python_scrapy/scrapy";
        }
        gameToUserDao.deleteGameTouserByGameId(gameId);
        scrapyService.buildScrapyStartFile(gameId,"tap",path);
        scrapyService.runScrapyStartFile(gameId,path);
    }

    @Scheduled(cron = "0 */2 * * * ?")
    public void UpdataGameToUser(){
        int gameId;
        gameId= (int) (Math.random() * 179428);
        String path=null;
        if(isWindows()){
            //判断运行在linux服务器上还是windows本机
            path="D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\java\\com\\UHT\\Insight\\Python_scrapy\\scrapy";
        }else {
            //运行在linux服务器上
            path="/root/Insight/src/main/java/com/UHT/Insight/Python_scrapy/scrapy";
        }
        gameToUserDao.deleteGameTouserByGameId(gameId);
        scrapyService.buildScrapyStartFile(gameId,"tap",path);
        scrapyService.runScrapyStartFile(gameId,path);
    }
    public boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
}
