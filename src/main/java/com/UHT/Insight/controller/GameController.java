package com.UHT.Insight.controller;

import com.UHT.Insight.daoImpl.GameDaoImpl;
import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.dto.ResultDTO;
import com.UHT.Insight.exception.CustomErrorCode;
import com.UHT.Insight.exception.CustomException;
import com.UHT.Insight.pojo.Game;
import com.UHT.Insight.pojo.GameTouser;
import com.UHT.Insight.pojo.Uuser;
import com.UHT.Insight.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GameController {


    @Autowired
    private GameInfoService gameInfoService;

    private GameDaoImpl gameDao=new GameDaoImpl();
    private GameToUserDaoImpl gameToUserDao=new GameToUserDaoImpl();


    @GetMapping("/game/{id}")
    public String game(@PathVariable String id) {
        return "test";
    }

    @ResponseBody
    @GetMapping("/game/{id}/Info")
    public ResultDTO<Game> gameInfo(@PathVariable(name = "id") Integer id){
        Game gameById = gameDao.findGameById(id);
        if(gameById==null){
            throw new CustomException(CustomErrorCode.GAME_NOT_FIND);
        }
        return ResultDTO.okOf(gameById);
    }

    @ResponseBody
    @GetMapping("/game/{id}/Comment")
    public ResultDTO<GameTouser> gameTouserComment(@PathVariable(name = "id") Integer id){
        GameTouser gameIdComment = gameToUserDao.findGameTouserById(id);
        if (gameIdComment ==null){
            throw new CustomException(CustomErrorCode.GAME_NOT_FIND);
        }
        return ResultDTO.okOf(gameIdComment);
    }

    @ResponseBody
    @GetMapping("/game/{id}/main")
    public ResultDTO<List<GameDayInfo>> game_main(@PathVariable(name = "id") Integer id) throws Exception {
        List<GameDayInfo> gameDayInfo;
        gameDayInfo =gameInfoService.findGameInfoCache(id);
        //先检查缓存数据表是否存在对应数据,若存在则从缓存数据表内提取
        if(gameDayInfo !=null){
            return ResultDTO.okOf(gameDayInfo);
        }
        else {
            //若不存在则查询应用数据表
            gameDayInfo = gameInfoService.getGameDayInfoList(id);
        }
        if(gameDayInfo ==null){
            return ResultDTO.errorOf(CustomErrorCode.GAME_NOT_FIND);
        }
        gameInfoService.saveGameInfoCache(id, gameDayInfo);
        //将查询结果写入缓冲数据库中
        return ResultDTO.okOf(gameDayInfo);
    }
}
