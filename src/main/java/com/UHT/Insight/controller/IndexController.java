package com.UHT.Insight.controller;


import com.UHT.Insight.daoImpl.GameDaoImpl;
import com.UHT.Insight.dto.ResultDTO;
import com.UHT.Insight.pojo.Game;
import com.UHT.Insight.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private GameInfoService gameInfoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/search/{keyword}")
    @ResponseBody
    public ResultDTO<List<Game>> searchGame(@PathVariable(name = "keyword") String keyword) {
        List<Game> games = gameInfoService.searchGameByKeyword(keyword);
        return ResultDTO.okOf(games);
    }
}
