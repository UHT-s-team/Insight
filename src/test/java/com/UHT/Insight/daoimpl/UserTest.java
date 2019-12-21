package com.UHT.Insight.daoimpl;

import com.UHT.Insight.dao.UserDao;
import com.UHT.Insight.daoImpl.UserDaoImpl;
import com.UHT.Insight.pojo.Uuser;
import org.junit.Test;

import java.util.List;

public class UserTest {
    private UserDaoImpl userDao=new UserDaoImpl();
    @Test
    public void findAll() {
           System.out.println(userDao.findAll());
        }
    @Test
    public void findUserById() {
        System.out.println(userDao.findUserById(1212));
    }
    @Test
    public void findUserByPhone() {
        Uuser user=userDao.findUserByPhone("18814233820");
        System.out.println(user.getUu_phone());
    }
    @Test
    public void deleteUser() {
        System.out.println(userDao.deleteUser(1212));
        }
    @Test
    public void updateUser() {
 //       Uuser uuser=new Uuser(1221,"小把","242","2321323",1,"213","2321");
 //       System.out.println(userDao.updateUser(uuser));
        }
    @Test
    public void saveUser() {
        //Uuser uuser=new Uuser(12888,"小艾","2232133132","2321323",1,"213","2321");
        //System.out.println(userDao.saveUser(uuser));
        //利用MBG生成了Uuser 的内容，以往测试用例已失效 --HN
        }
}

