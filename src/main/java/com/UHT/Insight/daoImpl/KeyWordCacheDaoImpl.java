package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.KeyWordCacheDao;
import com.UHT.Insight.pojo.KeyWordCache;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class KeyWordCacheDaoImpl {
    private SqlSession session= MybatilsUtils.getSession();
    private KeyWordCacheDao keyWordCacheDao=session.getMapper(KeyWordCacheDao.class);
    //读取数据
    public KeyWordCache findKeyWordCacheById(Integer K_ID){
        KeyWordCache keyWordCache=null;
        try {
            keyWordCache=keyWordCacheDao.findKeyWordCacheById(K_ID);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
            return keyWordCache;
        }finally {
            session.close();
        }
        return keyWordCache;
    }
    //插入数据
    public Integer saveKeyWordDataCache(KeyWordCache keyWordCache){
        Integer i=-1;
        try {
            i=keyWordCacheDao.saveKeyWordDataCache(keyWordCache);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
            return i;
        }finally {
            session.close();
        }
        return i;
    }
    //更新数据
    public Integer updateKeyWordDataCache(KeyWordCache keyWordCache){
        Integer i=-1;
        try {
            i=keyWordCacheDao.updateKeyWordDataCache(keyWordCache);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
            return i;
        }finally {
            session.close();
        }
        return i;
    }
    //查找所有的id及创建时间
    public List<KeyWordCache> findAllKeyWordDataCache(){
        List<KeyWordCache> list=null;
        try {
            list=keyWordCacheDao.findAllKeyWordDataCache();
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
            return list;
        }finally {
            session.close();
        }
        return list;
    }
}
