package com.UHT.Insight.daoimpl;

import com.UHT.Insight.daoImpl.RecentAppraiseDaoImpl;
import org.junit.Test;

public class RecentAppraiseTest {
    private RecentAppraiseDaoImpl recentAppraiseDao=new RecentAppraiseDaoImpl();
    //查询所有
    @Test
   public void findAll(){
       System.out.println(recentAppraiseDao.findAll());
   }
    //插入
    public void saveRecentAppraise(){

    }
    //根据id查询
    public void findRecentAppraiseById(){
       System.out.println(recentAppraiseDao.findRecentAppraiseById(1));
    }
    //根据id删除
    public void deleteRecentAppraiseById(){

    }
    //根据id修改
    public void updateRecntAppraiseById(){

    }
}
