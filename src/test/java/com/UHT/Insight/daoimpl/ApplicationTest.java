package com.UHT.Insight.daoimpl;

import com.UHT.Insight.dao.ApplicationDao;
import com.UHT.Insight.daoImpl.ApplicationDaoImpl;
import com.UHT.Insight.pojo.Application;
import org.junit.Test;

import java.util.List;

public class ApplicationTest {
    private ApplicationDaoImpl applicationDao;
    @Test
    public void applicationFindAll(){
        //执行查询所有方法
        applicationDao=new ApplicationDaoImpl();
        List<Application> posts=applicationDao.findAll();
        for(Application post : posts){
            System.out.println(post);
        }

    }
    @Test
    public void findById(){
        applicationDao=new ApplicationDaoImpl();
        Application applications = applicationDao.findAppById(1232357);
        System.out.println(applications);

    }
    @Test
    public void updateAppByApp(){
        applicationDao=new ApplicationDaoImpl();
        Application application=new Application(1232357,23123.2f,12121,"1.1.1","老鼠爱大米","老鼠事件");
        int applications = applicationDao.updateAppByApp(application);
        System.out.println(applications);

    }
    @Test
    public void saveApp(){
        applicationDao=new ApplicationDaoImpl();
        Application applications =new Application(1232357,23123.2f,12121,"1.1.1","老鼠爱大米","老鼠事件");
        applicationDao.saveApp(applications);
    }

}
