package com.UHT.Insight.service;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HanLPService {
    public List<Term> HanLPtest(String s) throws IOException {
        CRFLexicalAnalyzer analyzer = new CRFLexicalAnalyzer();

        return null;
    }
}
