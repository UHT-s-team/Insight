package com.UHT.Insight.daoimpl;

import com.UHT.Insight.dao.TapUserDao;
import com.UHT.Insight.daoImpl.TapUserDaoImpl;
import com.UHT.Insight.pojo.TapUser;
import org.junit.Test;


public class TapUserTest {
    private TapUserDao tapUserDao=new TapUserDaoImpl();
    @Test
    public void findAll() {
          System.out.println(tapUserDao.findAll());
    }
    @Test
    public void findTapUserById() {
           System.out.println(tapUserDao.findTapUserById(1));
    }
    @Test
    public void deleteTapUser() {
           System.out.println(tapUserDao.deleteTapUser(2));
    }
    @Test
    public void updateTapUser() {
        TapUser tapUser=new TapUser(3,"wewqew",1212,2121,121,1212,212,111,1.1f);
        System.out.println(tapUserDao.updateTapUser(tapUser));
    }
    @Test
    public void SaveTapUser() {
        TapUser tapUser=new TapUser(3,"wewqew",43443,2121,121,1212,212,111,1.1f);
        System.out.println(tapUserDao.SaveTapUser(tapUser));
    }

}
