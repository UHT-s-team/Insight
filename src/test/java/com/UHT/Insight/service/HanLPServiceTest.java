package com.UHT.Insight.service;

import com.UHT.Insight.daoImpl.KeyWordCacheDaoImpl;
import com.UHT.Insight.dto.CommentKeywordDTO;
import com.UHT.Insight.dto.GameDayKeywordDTO;
import com.UHT.Insight.pojo.KeyWordCache;
import com.UHT.Insight.utils.CacheUtils;
import com.hankcs.hanlp.corpus.document.sentence.Sentence;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class HanLPServiceTest {

    @Autowired
    HanLPService hanLPService;

    private KeyWordCacheDaoImpl keyWordCacheDao=new KeyWordCacheDaoImpl();

    private String comment = "怎么说呢？我也不喜欢抄袭，但我更不喜欢一边反对抄袭，同时也不愿意支持正版，整天还口嗨，嘲讽别人抄袭。如果是正版的塞尔达玩家自然有资格去评价抄没抄袭，毕竟他们是对塞尔达游戏内容体会最深的人。塞尔达到2019全球才卖出1500w+，中国有多少份。全网黑原神的有多少人，黑的人比国内销量高了多少。要黑至少先买一份再说。至少正版塞尔达玩家花了钱，有这个资格。没花钱的还有玩过盗版的人有什么资格。";

    @Test
    void getCommentKeyword() throws IOException {

        HashMap<String, Integer> commentKeyword = hanLPService.getCommentKeyword(comment);
        System.out.println();
    }


    @Test
    public void fastCommentKeyword() throws IOException {
        HashMap<String, Integer> commentKeyword = hanLPService.fastCommentKeyword(comment);
        System.out.println();
    }
    @Test
    public void getGameDayKeyword() throws Exception {
        List<GameDayKeywordDTO> gameDayKeyword = hanLPService.getGameDayKeyword(168332);

        for (ListIterator<GameDayKeywordDTO> it = gameDayKeyword.listIterator(); it.hasNext(); ) {
            GameDayKeywordDTO commentKeyword = it.next();
            for (Iterator<Map.Entry<String, Integer>> it2 =commentKeyword.getKeywordMap().entrySet().iterator();it2.hasNext();){
                Map.Entry<String, Integer> map = it2.next();
                if(map.getValue()<10){
                    it2.remove();
                }
            }
        }

        KeyWordCache cache=new KeyWordCache();//保存至缓冲表内
        cache.setCreateTime(new  Date( System.currentTimeMillis()));
        cache.setK_ID(168332);
        cache.setKeyWordCache(CacheUtils.obj2byte(gameDayKeyword));
        byte[] bytes = CacheUtils.obj2byte(gameDayKeyword);

//        Integer integer=bytes.length;
//        File outputFile = new File("output.txt");
//        FileOutputStream fileOutputStream=new FileOutputStream(outputFile);
//        fileOutputStream.write(bytes);

        keyWordCacheDao.saveKeyWordDataCache(cache);
        System.out.println();
    }

    @Test
    public void HanLPTest() throws IOException {
        long l = System.currentTimeMillis();
        HashMap<String, Integer> map=null;
        HashMap<String, Integer> commentKeyword = null;

        for (int i = 0; i < 10; i++) {
            commentKeyword = hanLPService.getCommentKeyword(comment);
        }
        long l2 = System.currentTimeMillis();

        long l3 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            map = hanLPService.fastCommentKeyword(comment);
        }
        long l4 = System.currentTimeMillis();


        System.out.println(l2-l);
        System.out.println(l4-l3);
        System.out.println(commentKeyword.toString());
        System.out.println(map.toString());
        System.out.println();
    }

}