package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.RecentAppraiseDao;
import com.UHT.Insight.pojo.RecentAppraise;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RecentAppraiseDaoImpl {
    private MybatilsUtils mybatilsUtils=new MybatilsUtils();
    private SqlSession sqlSession=mybatilsUtils.getSession();
    private RecentAppraiseDao recentAppraiseDao=sqlSession.getMapper(RecentAppraiseDao.class);
    //查询所有
    public List<RecentAppraise> findAll() {
        List<RecentAppraise> list=null;
        try {
            list = recentAppraiseDao.findAll();
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //插入
    public Integer saveRecentAppraise(RecentAppraise recentAppraise) {
        int i=-1;
        try {
            i=recentAppraiseDao.saveRecentAppraise(recentAppraise);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }

   //根据ID查询
    public RecentAppraise findRecentAppraiseById(Integer R_ID) {
        RecentAppraise recentAppraise=null;
        try{
            recentAppraise=recentAppraiseDao.findRecentAppraiseById(R_ID);
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return recentAppraise;
        }
        return recentAppraise;
    }

    //根据id删除
    public Integer deleteRecentAppraiseById(Integer R_ID) {
        int i=-1;
        try{
            i=recentAppraiseDao.deleteRecentAppraiseById(R_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }

    //更新
    public Integer updateRecntAppraise(RecentAppraise recentAppraise) {
        int i=0;
        try{
            i=recentAppraiseDao.updateRecntAppraise(recentAppraise);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
}
