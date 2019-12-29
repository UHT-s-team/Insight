package com.UHT.Insight.provide;

import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.service.ScrapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutoUpdataGameToUser {

    private ScrapyService scrapyService=new ScrapyService();

    private GameToUserDaoImpl gameToUserDao=new GameToUserDaoImpl();

    @Scheduled()
    public void UpdataGameToUser(){

        int gameId=181583;
        String path=null;
        if(true){
            //判断运行在linux服务器上还是windows本机
            path="D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\java\\com\\UHT\\Insight\\Python_scrapy\\scrapy";
        }else {
            //运行在linux服务器上
        }
        gameToUserDao.deleteGameTouserByGameId(gameId);
        scrapyService.buildScrapyStartFile(gameId,"tap",path);
        scrapyService.runScrapyStartFile(gameId,path);
    }
}
