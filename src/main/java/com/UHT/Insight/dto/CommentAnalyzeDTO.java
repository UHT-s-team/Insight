package com.UHT.Insight.dto;

import com.UHT.Insight.pojo.GameTouser;
import lombok.Data;

import java.util.List;

@Data
public class CommentAnalyzeDTO {
    public List<GameTouser> hotLabelComment;//标签组合对应的热评
    public List<String> allCindex;//标签list

}
