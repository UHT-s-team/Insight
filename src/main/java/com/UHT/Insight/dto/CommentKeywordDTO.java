package com.UHT.Insight.dto;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;

@Data
public class CommentKeywordDTO {
    private HashMap<String,Integer> keywordMap;//某条评论的关键字
    private Date time;         //评论的时间
}
