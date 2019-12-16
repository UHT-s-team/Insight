package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.RecentPlayDao;
import com.UHT.Insight.pojo.RecentPlay;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RecentPlayDaoImpl {
    private SqlSession sqlSession= MybatilsUtils.getSession();
    private RecentPlayDao recentPlayDao=sqlSession.getMapper(RecentPlayDao.class);
    //查询所有
    public List<RecentPlay> findAll() {
        List<RecentPlay> recentPlays=null;
        try {
            recentPlays=recentPlayDao.findAll();
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return recentPlays;
        }finally {
            sqlSession.close();
        }
        return recentPlays;
    }
    //插入
    public Integer saveRecentPlay(RecentPlay recentPlay) {
        int i=-1;
        try {
            i=recentPlayDao.saveRecentPlay(recentPlay);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
    //根据Id查询
    public RecentPlay findRecentPlayById(Integer R_ID) {
        RecentPlay recentPlay=null;
        try {
            recentPlay=recentPlayDao.findRecentPlayById(R_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return recentPlay;
        }finally {
            sqlSession.close();
        }
        return recentPlay;
    }
   //更新
    public Integer updateRecentPlay(RecentPlay recentPlay) {
        int i=0;
        try {
            i=recentPlayDao.updateRecentPlay(recentPlay);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
   //删除
    public Integer deleteRecentPlayById(Integer R_ID) {
        int i=-1;
        try {
            i=recentPlayDao.deleteRecentPlayById(R_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
    //批量插入
    public Integer saveRecentPlayList(List<RecentPlay> list) {
        int i=-1;
        try {
            i=recentPlayDao.saveRecentPlayList(list);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }finally {
            sqlSession.close();
        }
        return i;
    }
}
