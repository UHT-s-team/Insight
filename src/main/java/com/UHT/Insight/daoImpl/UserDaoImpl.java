package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.UserDao;
import com.UHT.Insight.pojo.Uuser;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl {
    private MybatilsUtils mybatilsUtils=new MybatilsUtils();
    private SqlSession sqlSession= mybatilsUtils.getSession();
    private UserDao userDao=sqlSession.getMapper(UserDao.class);

    //查询所有
    public List<Uuser> findAll() {
        List<Uuser> list=null;
        try {
            list = userDao.findAll();
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return list;
        }
        return list;
    }
   //根据id查询
    public Uuser findUserById(Integer UU_ID) {
        Uuser uuser=null;
        try {
            uuser=userDao.findUserById(UU_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return uuser;
        }
        return uuser;
    }
    //删除
    public Integer deleteUser(Integer UU_ID) {
        int i=-1;
        try {
            i=userDao.deleteUser(UU_ID);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //更新
    public Integer updateUser(Uuser uuser) {
        int i=0;
        try {
            i=userDao.updateUser(uuser);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //插入
    public Integer saveUser(Uuser uuser) {
        int i=-1;
        try {
            i=userDao.saveUser(uuser);
           sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return i;
        }
        return i;
    }
    //根据phone查询
    public Uuser findUserByPhone(String uuPhone){
        Uuser uuser=null;
        try {
            uuser=userDao.findUserByPhone(uuPhone);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            return uuser;
        }
        return uuser;
    }
}
