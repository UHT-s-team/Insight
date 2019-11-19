package com.UHT.Insight.daoImpl;

import com.UHT.Insight.dao.UserDao;
import com.UHT.Insight.pojo.Uuser;
import com.UHT.Insight.utils.MybatilsUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession= MybatilsUtils.getSession();
    private UserDao userDao=sqlSession.getMapper(UserDao.class);

    //查询所有
    public List<Uuser> findAll() {
        List<Uuser> list=null;
        try {
            list = userDao.findAll();
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return list;
    }
   //根据id查询
    public Uuser findUserById(Integer UU_ID) {
        Uuser uuser=null;
        try {
            uuser=userDao.findUserById(UU_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return uuser;
    }
    //删除
    public Integer deleteUser(Integer UU_ID) {
        int i=-1;
        try {
            i=userDao.deleteUser(UU_ID);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
    //更新
    public Integer updateUser(Uuser uuser) {
        int i=-1;
        try {
            i=userDao.updateUser(uuser);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
    //插入
    public Integer saveUser(Uuser uuser) {
        int i=-1;
        try {
            i=userDao.saveUser(uuser);
            MybatilsUtils.destroy();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return i;
    }
}
