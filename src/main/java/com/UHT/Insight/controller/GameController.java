package com.UHT.Insight.controller;

import com.UHT.Insight.daoImpl.GameDaoImpl;
import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.daoImpl.KeyWordCacheDaoImpl;
import com.UHT.Insight.dto.*;
import com.UHT.Insight.exception.CustomErrorCode;
import com.UHT.Insight.exception.CustomException;
import com.UHT.Insight.pojo.*;
import com.UHT.Insight.service.GameInfoService;
import com.UHT.Insight.service.HanLPService;
import com.UHT.Insight.utils.CacheUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {

    private GameInfoService gameInfoService=new GameInfoService();
    private GameDaoImpl gameDao=new GameDaoImpl();
    private GameToUserDaoImpl gameToUserDao=new GameToUserDaoImpl();
    private HanLPService hanLPService=new HanLPService();
    private KeyWordCacheDaoImpl keyWordCacheDao=new KeyWordCacheDaoImpl();


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
    @GetMapping("/game/{id}/comment")
    public ResultDTO<List<GameTouser>> gameTouserComment(@PathVariable(name = "id") Integer id){
        List<GameTouser> gameIdComment = gameToUserDao.findGameTouserByGId(id);
        if (gameIdComment ==null){
            throw new CustomException(CustomErrorCode.GAME_NOT_FIND);
        }
        return ResultDTO.okOf(gameIdComment);
    }

    @ResponseBody
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public Object page(@RequestBody GamePageDTO gamePageDTO) {
        Integer gameId = gamePageDTO.getGameId();
        Integer currentPage = gamePageDTO.getCurrentPage();
        Integer pageSize = gamePageDTO.getPageSize();
        PageDTO<GameTouser> pageDTO = gameInfoService.list(gameId, currentPage, pageSize);
        return ResultDTO.okOf(pageDTO);
    }

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
}
