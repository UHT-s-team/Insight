package com.UHT.Insight.controller;

import com.UHT.Insight.dto.ResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {
    @GetMapping("/game/{id}")
    public String game() {
        return "test";
    }

    @ResponseBody
    @GetMapping("/game/{id}/main")
    public ResultDTO<Integer> game_main(@PathVariable(name = "id") Integer id) {

        return ResultDTO.okOf(id);
    }
}
