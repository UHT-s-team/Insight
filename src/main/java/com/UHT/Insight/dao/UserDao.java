package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.Uuser;

import java.util.List;

/**
 * <p>Title: UserDao</p>
 * <p>Description: 用户的持久层操作</p>
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return list
     */
    List<Uuser> findAll();
    //根据id查询
    Uuser findUserById(Integer UU_ID);
    //根据id删除
    Integer deleteUser(Integer UU_ID);
    //根据id更新
    Integer updateUser(Uuser uuser);
    //插入
    Integer saveUser(Uuser uuser);
}
