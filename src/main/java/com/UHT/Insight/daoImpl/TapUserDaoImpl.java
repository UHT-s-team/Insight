package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.TapUserDao;
import com.UHT.Insight.pojo.TapUser;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TapUserDaoImpl {
    private MybatilsUtils mybatilsUtils=new MybatilsUtils();
    private SqlSession sqlSession= mybatilsUtils.getSession();
    private TapUserDao tapUserDao=sqlSession.getMapper(TapUserDao.class);
    //查询所有
    public List<TapUser> findAll() {
        List<TapUser> list=null;
        try {
            list = tapUserDao.findAll();
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
    //根据ID查询
    public TapUser findTapUserById(Integer U_ID) {
        TapUser tapUser=null;
        try{
            tapUser=tapUserDao.findTapUserById(U_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return tapUser;
        }
        return tapUser;
    }
    //删除
    public Integer deleteTapUser(Integer U_ID) {
        int i=-1;
        try{
            i=tapUserDao.deleteTapUser(U_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //更新
    public Integer updateTapUser(TapUser tapUser) {
        int i=0;
        try{
            i=tapUserDao.updateTapUser(tapUser);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //插入
    public Integer SaveTapUser(TapUser tapUser) {
        int i=-1;
        try {
            i=tapUserDao.SaveTapUser(tapUser);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //批量插入
    public Integer SaveTapUserList(List<TapUser> list) {
        int i=-1;
        try {
            i=tapUserDao.SaveTapUserList(list);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
}
