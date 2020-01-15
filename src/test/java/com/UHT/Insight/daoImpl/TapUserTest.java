package com.UHT.Insight.daoImpl;

import com.UHT.Insight.pojo.TapUser;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TapUserTest {
    private TapUserDaoImpl tapUserDao = new TapUserDaoImpl();

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
        TapUser tapUser = new TapUser(3, "wewqew", 1212, 2121, 121, 1212, 212, 111, 1.1f,1,"水军",new Date());
        System.out.println(tapUserDao.updateTapUser(tapUser));
    }

    @Test
    public void SaveTapUser() {
        TapUser tapUser = new TapUser(3, "wewqew", 43443, 2121, 121, 1212, 212, 111, 1.1f,1,"水军",new Date());
        System.out.println(tapUserDao.SaveTapUser(tapUser));
    }
    @Test
    public void SaveTapUserList() {
        TapUser tapUser = new TapUser(31, "wewqew", 43443, 2121, 121, 1212, 212, 111, 1.1f,1,"水军",new Date());
        TapUser tapUser1 = new TapUser(311, "wewqew", 43443, 2121, 121, 1212, 212, 111, 1.1f,1,"水军",new Date());
        List<TapUser> list=new ArrayList<>();
        list.add(tapUser);
        list.add(tapUser1);
        System.out.println(tapUserDao.SaveTapUserList(list));
    }
    @Test
    public void findTapUserBeforeDate(){
        Date date=null;
        try {
            date=new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-26");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<TapUser> list=tapUserDao.findTapUserBeforeDate(date);
        System.out.println(list);
    }

}
