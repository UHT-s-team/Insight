package com.UHT.Insight.controller;

import com.UHT.Insight.daoImpl.GameDayInfoCacheDaoImpl;
import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.dto.ResultDTO;
import com.UHT.Insight.pojo.GameDayInfoCache;
import com.UHT.Insight.pojo.GameEverydayData;
import com.UHT.Insight.pojo.GameStarLevel;
import com.UHT.Insight.service.GameInfoService;
import com.mysql.jdbc.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static com.UHT.Insight.utils.CacheUtils.obj2byte;

@Controller
public class GameController {


    @Autowired
    private GameInfoService gameInfoService;

    private GameDayInfoCacheDaoImpl gameDayInfoCacheDao=new GameDayInfoCacheDaoImpl();

    @GetMapping("/game/{id}")
    public String game(@PathVariable String id) {
        return "test";
    }

    @ResponseBody
    @GetMapping("/game/{id}/main")
    public ResultDTO<List<GameDayInfo>> game_main(@PathVariable(name = "id") Integer id) throws Exception {
        //先检查缓存数据表是否存在对应数据
        //若存在则从缓存数据表内提取
        //若不存在则查询应用数据表
        List<GameDayInfo> gameDayInfoList = gameInfoService.getGameDayInfoList(id);

        GameDayInfoCache gameDayInfoCache = new GameDayInfoCache();
        gameDayInfoCache.setG_ID(id);
        gameDayInfoCache.setInfoCache(obj2byte(gameDayInfoList));
        gameDayInfoCache.setCreateTime(new Date(System.currentTimeMillis()));
        gameDayInfoCacheDao.saveGameDataCache(gameDayInfoCache);

        //将查询结果写入数据库中
        return ResultDTO.okOf(gameDayInfoList);
    }
}
