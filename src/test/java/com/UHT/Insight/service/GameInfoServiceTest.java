package com.UHT.Insight.service;

import com.UHT.Insight.dto.GameDayInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameInfoServiceTest {

    GameInfoService gameInfoService=new GameInfoService();
    @Test
    void getGameDayInfoList() {
        List<GameDayInfo> gameDayInfoList = gameInfoService.getGameDayInfoList(23234);
        System.out.println(gameDayInfoList);
    }
}