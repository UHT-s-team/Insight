package com.UHT.Insight.controller;

import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.dto.ResultDTO;
import com.UHT.Insight.pojo.GameEverydayData;
import com.UHT.Insight.pojo.GameStarLevel;
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

    @GetMapping("/game/{id}")
    public String game(@PathVariable String id) {
        return "test";
    }

    @ResponseBody
    @GetMapping("/game/{id}/main")
    public ResultDTO<List<GameDayInfo>> game_main(@PathVariable(name = "id") Integer id) {
        List<GameDayInfo> gameDayInfoList = gameInfoService.getGameDayInfoList(id);
        return ResultDTO.okOf(gameDayInfoList);
    }
}
