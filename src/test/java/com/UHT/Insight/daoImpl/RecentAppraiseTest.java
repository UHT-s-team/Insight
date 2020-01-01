package com.UHT.Insight.daoImpl;

import com.UHT.Insight.pojo.RecentAppraise;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecentAppraiseTest {

    private RecentAppraiseDaoImpl recentAppraiseDao=new RecentAppraiseDaoImpl();
    //查询所有
    @Test
    public void findAll(){
        System.out.println(recentAppraiseDao.findAll().toString());
    }
    //插入
    @Test
    public void saveRecentAppraise(){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-11-15 16:14:0");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RecentAppraise recentAppraise=new RecentAppraise(112,12121,"12121",date,1.0f,123232);
        System.out.println(recentAppraiseDao.saveRecentAppraise(recentAppraise));
    }
    //根据id查询
    @Test
    public void findRecentAppraiseById(){
           System.out.println(recentAppraiseDao.findRecentAppraiseById(111));
    }
    //根据id删除
    @Test
    public void deleteRecentAppraiseById(){
          System.out.println(recentAppraiseDao.deleteRecentAppraiseById(111));
    }
    //根据id修改
    @Test
    public void  updateRecntAppraise(){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-11-15 16:14:0");
        } catch (ParseException e) {
            e.printStackTrace();
        }
          RecentAppraise recentAppraise=new RecentAppraise(112,12111,"12121",date,1.0f,123232);
          System.out.println(recentAppraiseDao.updateRecntAppraise(recentAppraise));
    }
}
