package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.Application;

import java.util.List;

public interface ApplicationDao {
    /*查询所有Application
    * @return
     */
    public List<Application> findAll();
    //根据查询应用ID(G_ID)获取application
    public Application findAppById(Integer G_ID);
    //根据ID（G_ID）更新application
    public Integer updateAppByApp(Application application);
    //添加application
    public Integer saveApp(Application application);
    //根据Id删除application
    public Integer deleteAppById(Integer G_ID);
    //分页查询

}
