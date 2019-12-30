package com.UHT.Insight.controller;

import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.dto.ResultDTO;
import com.UHT.Insight.provide.AutoUpdataGameToUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AutoUpdataGameToUser autoUpdataGameToUser;

    @ResponseBody
    @GetMapping("/root/{gameId}")
    public ResultDTO<String> getGamToUserApi(@PathVariable(name = "gameId") int gameId){
        autoUpdataGameToUser.UpdataGameToUser(gameId);
        return ResultDTO.okOf("获取成功");
    }
}
