package com.UHT.Insight.controller;

import com.UHT.Insight.daoImpl.GameDaoImpl;
import com.UHT.Insight.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IdController {

    @Autowired
    private GameInfoService gameInfoService;

    private GameDaoImpl gameDao=new GameDaoImpl();


    @GetMapping("/game/{id}")
    public String game(@PathVariable String id){
        return "/game/{id}/Info";
    }

}
