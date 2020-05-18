package com.UHT.Insight.controller;

import com.UHT.Insight.daoImpl.GameDaoImpl;
import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.daoImpl.KeyWordCacheDaoImpl;
import com.UHT.Insight.daoImpl.KmeansDao;
import com.UHT.Insight.dto.*;
import com.UHT.Insight.exception.CustomErrorCode;
import com.UHT.Insight.exception.CustomException;
import com.UHT.Insight.pojo.*;
import com.UHT.Insight.service.DataAnalyzeService;
import com.UHT.Insight.service.GameInfoService;
import com.UHT.Insight.service.HanLPService;
import com.UHT.Insight.utils.CacheUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    private GameInfoService gameInfoService=new GameInfoService();
    private GameDaoImpl gameDao=new GameDaoImpl();
    private GameToUserDaoImpl gameToUserDao=new GameToUserDaoImpl();
    private HanLPService hanLPService=new HanLPService();
    private KeyWordCacheDaoImpl keyWordCacheDao=new KeyWordCacheDaoImpl();
    private DataAnalyzeService dataAnalyzeService=new DataAnalyzeService();

    @Autowired
    private KmeansDao kmeansDao;


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

//    @ResponseBody
//    @GetMapping("/game/{id}/comment")
//    public ResultDTO<List<GameTouser>> gameTouserComment(@PathVariable(name = "id") Integer id){
//        List<GameTouser> gameIdComment = gameToUserDao.findGameTouserByGId(id);
//        if (gameIdComment ==null){
//            throw new CustomException(CustomErrorCode.GAME_NOT_FIND);
//        }
//        return ResultDTO.okOf(gameIdComment);
//    }

    @ResponseBody
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public Object page(@RequestBody GamePageDTO gamePageDTO) {
        Integer gameId = gamePageDTO.getGameId();
        Integer currentPage = gamePageDTO.getCurrentPage();
        Integer pageSize = gamePageDTO.getPageSize();
        PageDTO<GameTouser> pageDTO = gameInfoService.list(gameId, currentPage, pageSize);
        return ResultDTO.okOf(pageDTO);
    }

//    @ResponseBody
//    @RequestMapping(value = "/symptomAnalysis",method = RequestMethod.POST)
//    public Object analysis(@RequestBody SymptomsDTO symptomsDTO) {
//        if(symptomsDTO!=null){
//            AnalysisResultDTO analysisResult =symptomService.analysis(symptomsDTO);
//            return ResultDTO.okOf(analysisResult);
//        }else {
//            return ResultDTO.errorOf(2002,"病症信息不能为空");
//        }
//    }
//
//    @Data
//    public class AnalysisResultDTO{
//        ArrayList<String> analysisResults;
//        //储存诊断结果,结果和概率用分号隔开，以便app端使用
//        // "牙周炎;0.89"
//        ArrayList<String> treatmentOptions;
//        //储存治疗方案 ”一般治疗;XXXXX“
//        ArrayList<String> suggests;
//        //储存生活建议 ”XXXXX“ 无特殊格式
//    }

    @ResponseBody
    @GetMapping("/game/{id}/Keyword")
    public ResultDTO<List<GameDayKeywordDTO>> gameDailyKeyword(@PathVariable(name = "id") Integer id) throws Exception {
        //List<GameDayKeywordDTO> gameDayKeywords=hanLPService.getGameDayKeyword(id);
        KeyWordCache keyWordCache=null;
        try {
            keyWordCache = keyWordCacheDao.findKeyWordCacheById(id);
        }catch (NullPointerException e){
            throw new CustomException(CustomErrorCode.GAME_NOT_FIND);
        }
        if(keyWordCache==null){
            return ResultDTO.errorOf(CustomErrorCode.GAME_NOT_FIND);
        }
        else {
            List<GameDayKeywordDTO> gameDayKeywords= (List<GameDayKeywordDTO>) CacheUtils.byte2obj(keyWordCache.getKeyWordCache());
            return ResultDTO.okOf(gameDayKeywords);
        }
    }

    @ResponseBody
    @GetMapping("/game/{id}/main")
    public ResultDTO<List<GameDayInfo>> game_main(@PathVariable(name = "id") Integer id) throws Exception {
        List<GameDayInfo> gameDayInfo;
        gameDayInfo =gameInfoService.findGameInfoCache(id);
        //先检查缓存数据表是否存在对应数据,若存在则从缓存数据表内提取
        if(gameDayInfo !=null){
            return ResultDTO.okOf(gameDayInfo);
        } else {
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

    @ResponseBody
    @PostMapping("/search/{id}/advancedQuery")
    public ResultDTO<String> advancedQuery(@RequestBody AdvancedQueryDTO advancedQuery,
                                           @PathVariable(name = "id") Integer gameId){
        List<TapUserAndGameToUser> unionByGId = gameToUserDao
                .findUnionByGId(gameId, -1, null, advancedQuery.getFans(), advancedQuery.getAttention(), advancedQuery.getCollect(), advancedQuery.getPlay(), advancedQuery.getL_play(), advancedQuery.getG_weight(), advancedQuery.getAppraise());
        return ResultDTO.okOf(unionByGId);
    }

    @ResponseBody
    @GetMapping("/hotComment/{id}")
    public ResultDTO<String> hotComment(@PathVariable(name = "id") Integer gameId){
        List<GameTouser> hotComment = gameToUserDao.hotComment(gameId, 6);
        return ResultDTO.okOf(hotComment);
    }

    @RequestMapping(value = "/WCImage/{id}", method = RequestMethod.GET)
    public ResultDTO<String> downloadWCImage(HttpServletResponse res,@PathVariable(name = "id") Integer gameId) {
        String fileName = gameId+".png";
        String filePath;
        if (isWindows()) {
            //判断运行在linux服务器上还是windows本机
            filePath = "D://学习//代码//JavaWeb//Insight//src//main//resources//static//img//";
        } else {
            //运行在linux服务器上
            filePath = "/root/Insight/src/main/resources/static/img/";
//                       "/root/Insight/src/main/resources/static/img"
        }
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(filePath + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResultDTO.errorOf(CustomErrorCode.File_NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultDTO.errorOf(CustomErrorCode.UNKNOWN_ERROR);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
        return ResultDTO.okOf("下载成功");
    }

    @ResponseBody
    @RequestMapping(value = "/commentClass/{id}",method = RequestMethod.GET)
    public ResultDTO<String> commentClass(@PathVariable(name = "id") Integer gameId){
        List<CommentAnalyzeDTO> allLabelComment=new ArrayList<>();
        CommentAnalyzeDTO commentAnalyzeDTO = null;
        Integer maxLabel = kmeansDao.maxLabelIndex(gameId);
        List<Integer> countComment=new ArrayList<>();
        for (int i = 1; i <= maxLabel; i++) {
            List<String> cindexForLabel = kmeansDao.getCindexForLabel(i, gameId);
            List<String> descTen = gameToUserDao.getDescTen(gameId, cindexForLabel);
//            预先获取每个label标签的所有cindax，找到其中最高的十个cindax
            List<GameTouser> gameTousers = gameToUserDao.likeComment(gameId,descTen,3,countComment);
//            根据cindax查找排名最高的组合
            if(gameTousers!=null){
                commentAnalyzeDTO=new CommentAnalyzeDTO();
                commentAnalyzeDTO.setAllCindex(cindexForLabel);
                commentAnalyzeDTO.setHotLabelComment(gameTousers);
                commentAnalyzeDTO.setCommentNum(countComment.get(0));
                allLabelComment.add(commentAnalyzeDTO);
                countComment.clear();
            }
            //按label封装DTO
            //dto内含当前cindex列表 高赞评论列表，对高赞情感分析列表
        }
        return ResultDTO.okOf(allLabelComment);
    }

    public boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
}
