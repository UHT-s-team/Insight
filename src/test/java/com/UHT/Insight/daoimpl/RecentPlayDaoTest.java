package com.UHT.Insight.daoimpl;

import com.UHT.Insight.daoImpl.RecentPlayDaoImpl;
import com.UHT.Insight.pojo.RecentPlay;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecentPlayDaoTest {
    private RecentPlayDaoImpl recentPlayDao=new RecentPlayDaoImpl();
    //查询所有
    @Test
    public void findAll(){
        System.out.println(recentPlayDao.findAll().toString());
    }
    //插入
    @Test
    public void saveRecentPlay(){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-11-15 16:14:0");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RecentPlay recentPlay=new RecentPlay(134332,2323,111,date);
        System.out.println(recentPlayDao.saveRecentPlay(recentPlay));
    }
    //根据ID查询
    @Test
    public void findRecentPlayById(){
        System.out.println(recentPlayDao.findRecentPlayById(134332));
    }
    //根据Id修改
    @Test
    public void updateRecentPlay(){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-11-15 16:14:0");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RecentPlay recentPlay=new RecentPlay(134332,23233,11,date);
        System.out.println(recentPlayDao.updateRecentPlay(recentPlay));
    }
    //根据ID删除
    @Test
    public void deleteRecentPlayById(){
         System.out.println(recentPlayDao.deleteRecentPlayById(134332));
    }
    @Test
    public void saveRecentPlayList(){
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-11-15 16:14:0");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<RecentPlay> list=new ArrayList<>();
        RecentPlay recentPlay1=new RecentPlay(1322332,2323,11,date);
        RecentPlay recentPlay=new RecentPlay(1213332,2323,111,date);
        list.add(recentPlay);
        list.add(recentPlay1);
        System.out.println(recentPlayDao.saveRecentPlayList(list));
    }
}
