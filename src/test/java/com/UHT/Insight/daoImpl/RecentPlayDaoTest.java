package com.UHT.Insight.daoImpl;

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
        RecentPlay recentPlay=new RecentPlay(1111,111,1111,"12时52分");
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
        RecentPlay recentPlay=new RecentPlay(134332,23233,11,"12时52分");
        System.out.println(recentPlayDao.updateRecentPlay(recentPlay));
    }
    //根据ID删除
    @Test
    public void deleteRecentPlayById(){
         System.out.println(recentPlayDao.deleteRecentPlayById(134332));
    }
    @Test
    public void saveRecentPlayList(){
        List<RecentPlay> list=new ArrayList<>();
        RecentPlay recentPlay1=new RecentPlay(2332,2323,11,"12时52分");
        RecentPlay recentPlay=new RecentPlay(13332,2323,111,"12时52分");
        list.add(recentPlay);
        list.add(recentPlay1);
        System.out.println(recentPlayDao.saveRecentPlayList(list));
    }
}
