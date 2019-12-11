package com.UHT.Insight.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.rmi.runtime.Log;

import java.io.InputStream;
import java.sql.SQLException;

public class MybatilsUtils {
    private static SqlSessionFactory sqlSessionFactory=null;
    private static SqlSession sqlSession=null;
//    private static InputStream in=null;
    static {
        try {
            //1.读取配置文件
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建 SqlSessionFactory 的构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.使用构建者创建工厂对象 SqlSessionFactory
            sqlSessionFactory = builder.build(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession对象的静态方法
    public static SqlSession getSession(){
        return sqlSession=sqlSessionFactory.openSession();
    }
    public static void destroy(){
        //提交事务
        sqlSession.commit();
        sqlSession=null;
        //6.释放资源
        System.out.println();
    }
}
