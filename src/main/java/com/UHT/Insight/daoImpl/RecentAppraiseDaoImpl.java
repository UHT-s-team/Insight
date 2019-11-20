package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.RecentAppraiseDao;
import com.UHT.Insight.pojo.RecentAppraise;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RecentAppraiseDaoImpl implements RecentAppraiseDao {
    private SqlSession sqlSession=MybatilsUtils.getSession();
    private RecentAppraiseDao recentAppraiseDao=sqlSession.getMapper(RecentAppraiseDao.class);
    @Override
    public List<RecentAppraise> findAll() {
        List<RecentAppraise> list=null;
        try {
            list = recentAppraiseDao.findAll();
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }

    @Override
    public Integer saveRecentAppraise(RecentAppraise recentAppraise) {
        int i=-1;
        try {
            i=recentAppraiseDao.saveRecentAppraise(recentAppraise);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }

    @Override
    public RecentAppraise findRecentAppraiseById(Integer R_ID) {
        RecentAppraise recentAppraise=null;
        try{
            recentAppraise=recentAppraiseDao.findRecentAppraiseById(R_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return recentAppraise;
        }
        return recentAppraise;
    }

    @Override
    public Integer deleteRecentAppraiseById(Integer R_ID) {
        int i=-1;
        try{
            i=recentAppraiseDao.deleteRecentAppraiseById(R_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }

    @Override
    public Integer updateRecntAppraise(RecentAppraise recentAppraise) {
        int i=-1;
        try{
            i=recentAppraiseDao.updateRecntAppraise(recentAppraise);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
}
