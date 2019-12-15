package com.UHT.Insight.service;

import com.UHT.Insight.daoImpl.GameToUserDaoImpl;
import com.UHT.Insight.dto.CommentKeywordDTO;
import com.UHT.Insight.dto.GameDayKeywordDTO;
import com.UHT.Insight.pojo.GameEverydayData;
import com.UHT.Insight.pojo.GameTouser;
import com.hankcs.hanlp.corpus.document.sentence.Sentence;
import com.hankcs.hanlp.corpus.document.sentence.word.IWord;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import org.apache.ibatis.javassist.compiler.KeywordTable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class HanLPService {

    private GameToUserDaoImpl gameToUserDao = new GameToUserDaoImpl();

    //获得评论的关键字哈希映射表 使用CRF 非常的慢
    public HashMap<String, Integer> getCommentKeyword(String comment) throws IOException {
        CRFLexicalAnalyzer analyzer = new CRFLexicalAnalyzer();
        Sentence analyze = analyzer.analyze(comment);
        List<IWord> wordsByLabel = analyze.findWordsByLabel("n");
        {
            wordsByLabel.addAll(analyze.findWordsByLabel("i"));
            wordsByLabel.addAll(analyze.findWordsByLabel("v"));
            wordsByLabel.addAll(analyze.findWordsByLabel("nz"));
            wordsByLabel.addAll(analyze.findWordsByLabel("nr"));
            wordsByLabel.addAll(analyze.findWordsByLabel("nrf"));
        }
        //n i v nz nr nrf
        Sentence iWords = new Sentence(wordsByLabel);
        String[] keywords = iWords.toWordArray();
        HashMap<String, Integer> keywordMap = new HashMap<>();
        for (String keyword : keywords) {
            if (keyword.length() > 1)
                keywordMap.put(keyword, 1);
        }
        return keywordMap;
    }


    //获得评论的关键字哈希映射表  使用NLP约是CRF的0.28
    public HashMap<String, Integer> fastCommentKeyword(String comment) throws IOException {
        List<Term> segment = NLPTokenizer.segment(comment);
        HashMap<String, Integer> keywordMap = new HashMap<>();
        for (Term term:segment){
            if(term.word.length()>1&&(term.nature.firstChar()=='n')){
                    keywordMap.put(term.word,1);
            }
        }
        return keywordMap;
    }

    public List<GameDayKeywordDTO> getGameDayKeyword(Integer gameId) throws IOException {
        List<GameDayKeywordDTO> gameDayKeywords = new LinkedList<>();
        List<GameEverydayData> everydayBaseData = gameToUserDao.findCountEverydayAll(gameId);
        //根据游戏id查询游戏的基本信息,最重要的是获取时间以便具体的评论对应
        {
            GameDayKeywordDTO keyword = new GameDayKeywordDTO();//无意义的工具
            for (GameEverydayData gameEverydayData : everydayBaseData) {
                BeanUtils.copyProperties(gameEverydayData, keyword);
                keyword.setKeywordMap(new HashMap<>());
                gameDayKeywords.add(keyword);
                keyword = new GameDayKeywordDTO();//重新实例化工具
            }
        }//初始化gameDayKeywords
        List<CommentKeywordDTO> commentKeywordMaps = new LinkedList<>();//使用链表以便增删改
        //用于储存游戏评论的hashMap及时间
        List<GameTouser> CommentByGIdList = gameToUserDao.findGameTouserByGId(gameId);
        //获得对应游戏的所有评论
//
        int i = 0; //这一行 连同下面76行均为测试时取消注释

        CommentKeywordDTO keywordTime = new CommentKeywordDTO();//工具
        for (GameTouser gameTouser : CommentByGIdList) {
            String comment = gameTouser.getD_CONTENT();
//            keywordTime.setKeywordMap(getCommentKeyword(comment));//使用非常慢的CRF分词
            keywordTime.setKeywordMap(getCommentKeyword(comment));//使用较快的NPL分词

            keywordTime.setTime(gameTouser.getI_TIME());
            if (keywordTime.getKeywordMap().isEmpty())//丢弃无法获得关键词的评论
                continue;
            commentKeywordMaps.add(keywordTime);
            keywordTime = new CommentKeywordDTO();

            if (i < 50) {
                i++;
            } else {
                break;
            }

        }

        //遍历评论，转为HashMap，加上时间，打包存入commentKeywordMaps
        for (GameDayKeywordDTO gameDayKeyword : gameDayKeywords) {
            HashMap<String, Integer> dayKeywordMap = gameDayKeyword.getKeywordMap();
            for (ListIterator<CommentKeywordDTO> it = commentKeywordMaps.listIterator(); it.hasNext(); ) {
                CommentKeywordDTO commentKeyword = it.next();
                //利用迭代器遍历commentKeywordMap（每日评论的关键词），以便进行移除操作
                if (gameDayKeyword.getTime().equals(commentKeyword.getTime())) {//判断时间是否为同一天
                    HashMap<String, Integer> contentKeyword = commentKeyword.getKeywordMap();
                    if (dayKeywordMap.isEmpty() || dayKeywordMap == null) {
                        dayKeywordMap = contentKeyword;
                    }
                    for (String keyword : contentKeyword.keySet()) {
                        if (dayKeywordMap.containsKey(keyword)) {
                            dayKeywordMap.put(keyword, dayKeywordMap.get(keyword) + 1);
                        } else {
                            dayKeywordMap.put(keyword, 1);
                        }
                    }
                    gameDayKeyword.setKeywordMap(dayKeywordMap);
                    it.remove();//移除当前评论
                }
            }
            gameDayKeyword.setKeywordMap(dayKeywordMap);
        }
        return gameDayKeywords;
    }
}
