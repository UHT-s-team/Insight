package com.UHT.Insight.dto;

import com.UHT.Insight.pojo.GameTouser;
import lombok.Data;

import java.util.List;

@Data
public class CommentAnalyzeDTO {
    private List<GameTouser> hotLabelComment;//标签组合对应的热评
    private List<String> allCindex;//标签list
    private Integer commentNum;
}
