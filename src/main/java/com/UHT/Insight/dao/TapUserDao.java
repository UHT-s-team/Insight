package com.UHT.Insight.dao;

import com.UHT.Insight.pojo.TapUser;

import java.util.List;

public interface TapUserDao {
    /**
     * 查询所有TapUser
     * @return list
     */
    List<TapUser> findAll();
    //根据id查询
    TapUser findTapUserById(Integer U_ID);
    //根据id删除
    Integer deleteTapUser(Integer U_ID);
    //根据id更新
    Integer updateTapUser(TapUser tapUser);
    //插入
    Integer SaveTapUser(TapUser tapUser);
    //批量插入
    Integer  SaveTapUserList(List<TapUser> list);
}
