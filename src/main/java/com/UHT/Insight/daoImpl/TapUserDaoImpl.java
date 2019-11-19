package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.TapUserDao;
import com.UHT.Insight.pojo.TapUser;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TapUserDaoImpl implements TapUserDao {
    private SqlSession sqlSession= MybatilsUtils.getSession();
    private TapUserDao tapUserDao=sqlSession.getMapper(TapUserDao.class);
    //查询所有
    public List<TapUser> findAll() {
        List<TapUser> list=null;
        try {
            list = tapUserDao.findAll();
            MybatilsUtils.destroy();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        return list;
    }
    //根据ID查询
    public TapUser findTapUserById(Integer U_ID) {
        TapUser tapUser=null;
        try{
            tapUser=tapUserDao.findTapUserById(U_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return tapUser;
    }
    //删除
    public Integer deleteTapUser(Integer U_ID) {
        int i=-1;
        try{
            i=tapUserDao.deleteTapUser(U_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
    //更新
    public Integer updateTapUser(TapUser tapUser) {
        int i=-1;
        try{
            i=tapUserDao.updateTapUser(tapUser);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
    //插入
    public Integer SaveTapUser(TapUser tapUser) {
        int i=-1;
        try {
            i=tapUserDao.SaveTapUser(tapUser);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
}
