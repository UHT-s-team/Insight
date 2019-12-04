package com.UHT.Insight.daoimpl;

import com.UHT.Insight.daoImpl.RecentPlayDaoImpl;
import com.UHT.Insight.pojo.RecentPlay;
import org.junit.Test;

import java.util.ArrayList;
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
        RecentPlay recentPlay=new RecentPlay(134332,2323,"校内","23122时","飙车",1.2f);
        System.out.println(recentPlayDao.saveRecentPlay(recentPlay));
    }
    //根据ID查询
    @Test
    public void findRecentPlayById(){
        System.out.println(recentPlayDao.findRecentPlayById(1111));
    }
    //根据Id修改
    @Test
    public void updateRecentPlay(){
        RecentPlay recentPlay=new RecentPlay(1132,23233,"校内","23122时","飙车",1.2f);
        System.out.println(recentPlayDao.updateRecentPlay(recentPlay));
    }
    //根据ID删除
    @Test
    public void deleteRecentPlayById(){
         System.out.println(recentPlayDao.deleteRecentPlayById(1111));
    }
    @Test
    public void saveRecentPlayList(){
        List<RecentPlay> list=new ArrayList<>();
        RecentPlay recentPlay1=new RecentPlay(1322332,2323,"校内","23122时","飙车",1.2f);
        RecentPlay recentPlay=new RecentPlay(1213332,2323,"校内","23122时","飙车",1.2f);
        list.add(recentPlay);
        list.add(recentPlay1);
        System.out.println(recentPlayDao.saveRecentPlayList(list));
    }
}
