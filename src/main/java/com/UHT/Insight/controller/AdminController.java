package com.UHT.Insight.controller;

import com.UHT.Insight.dto.GameDayInfo;
import com.UHT.Insight.dto.ResultDTO;
import com.UHT.Insight.provide.AutoUpdataGameToUser;
import com.UHT.Insight.service.DataAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AutoUpdataGameToUser autoUpdataGameToUser;
    DataAnalyzeService dataAnalyzeService=new DataAnalyzeService();

    @ResponseBody
    @GetMapping("/root/{gameId}")
    public ResultDTO<String> getGamToUserApi(@PathVariable(name = "gameId") int gameId){
        autoUpdataGameToUser.UpdataGameToUser(gameId);
        return ResultDTO.okOf("获取成功");
    }

    @ResponseBody
    @RequestMapping(value = "/root/buildWCImage/{id}", method = RequestMethod.GET)
    public ResultDTO<String> buildWCImage(@PathVariable(name = "id") Integer gameId){
        String filePath,wordCloudPath;
        if (isWindows()) {
            //判断运行在linux服务器上还是windows本机
            filePath = "D:\\学习\\代码\\JavaWeb\\Insight\\src\\main\\java\\com\\UHT\\Insight\\Python_analyze";
                    //"D://学习//代码//JavaWeb//Insight//src//main//resources//static//img//";
            wordCloudPath=filePath+"\\wordCloud";
        } else {
            //运行在linux服务器上
            filePath = "/root/Insight/src/main/java/com/UHT/Insight/Python_analyze";
//                       "/root/Insight/src/main/resources/static/img"
            wordCloudPath=filePath+"/wordCloud";
        }
        dataAnalyzeService.buildStartFile(gameId.toString(),"TFIDF",500,filePath);
        dataAnalyzeService.runStartFile("TFIDF",filePath);
        dataAnalyzeService.worldCloud(gameId.toString(),wordCloudPath);
        return ResultDTO.okOf("构建成功");
    }
    public boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
//    @ResponseBody
//    @GetMapping("/root/{gameId}")
//    public ResultDTO
}
