package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.KeyWordCache;

import java.util.List;

public interface KeyWordCacheDao {
    //读取数据
    public KeyWordCache findKeyWordCacheById(Integer K_ID);
    //插入数据
    public Integer saveKeyWordDataCache(KeyWordCache keyWordCache);
    //更新数据
    public Integer updateKeyWordDataCache(KeyWordCache keyWordCache);
    //查找所有的id及创建时间
    public List<KeyWordCache> findAllKeyWordDataCache();

}

