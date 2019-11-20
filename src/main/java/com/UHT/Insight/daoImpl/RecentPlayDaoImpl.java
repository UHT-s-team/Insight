package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.RecentPlayDao;
import com.UHT.Insight.pojo.RecentPlay;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RecentPlayDaoImpl implements RecentPlayDao {
    private SqlSession sqlSession= MybatilsUtils.getSession();
    private RecentPlayDao recentPlayDao=sqlSession.getMapper(RecentPlayDao.class);
    //查询所有
    @Override
    public List<RecentPlay> findAll() {
        List<RecentPlay> recentPlays=null;
        try {
            recentPlays=recentPlayDao.findAll();
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return recentPlays;
        }
        return recentPlays;
    }
    //插入
    @Override
    public Integer saveRecentPlay(RecentPlay recentPlay) {
        int i=-1;
        try {
            i=recentPlayDao.saveRecentPlay(recentPlay);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //根据Id查询
    @Override
    public RecentPlay findRecentPlayById(Integer G_ID) {
        RecentPlay recentPlay=null;
        try {
            recentPlay=recentPlayDao.findRecentPlayById(G_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return recentPlay;
        }
        return recentPlay;
    }
   //更新
    @Override
    public Integer updateRecentPlay(RecentPlay recentPlay) {
        int i=-1;
        try {
            i=recentPlayDao.updateRecentPlay(recentPlay);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
   //删除
    @Override
    public Integer deleteRecentPlayById(Integer G_ID) {
        int i=-1;
        try {
            i=recentPlayDao.deleteRecentPlayById(G_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
}
