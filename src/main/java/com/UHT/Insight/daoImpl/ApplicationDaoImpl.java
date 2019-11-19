package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.ApplicationDao;
import com.UHT.Insight.pojo.Application;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ApplicationDaoImpl implements ApplicationDao {
    private SqlSession sqlSession= MybatilsUtils.getSession();
    private ApplicationDao applicationDao=sqlSession.getMapper(ApplicationDao.class);;
    //查询所有
    public List<Application> findAll(){
        List<Application> list=null;
        try {
            list = applicationDao.findAll();
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }

        return list;
    }
    //插入数据
    public Integer saveApp(Application application){
        int i=-1;
        try {
            i=applicationDao.saveApp(application);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
    //根据ID查找
    public Application findAppById(Integer G_ID){
        Application application=null;
        try{
            application=applicationDao.findAppById(G_ID);
            MybatilsUtils.destroy();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return application;
    }
    //更新
    public Integer updateAppByApp(Application application){
        int i=-1;
        try{
            i=applicationDao.updateAppByApp(application);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
    //根据ID删除
    public Integer deleteAppById(Integer G_ID){
        int i=-1;
        try {
            i=applicationDao.deleteAppById(G_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
}
