package com.UHT.Insight.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class MybatilsUtils {
//    private static SqlSessionFactory sqlSessionFactory=null;
////    private static SqlSession sqlSession=null;
////    private static InputStream in=null;
//    static {
//        try {
//            //1.读取配置文件
//            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//            //2.创建 SqlSessionFactory 的构建者对象
//            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            //3.使用构建者创建工厂对象 SqlSessionFactory
//            sqlSessionFactory = builder.build(in);
//            in.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public DataSource getDataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDataSource(null);

        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }

    //获取SqlSession对象的静态方法
    public  SqlSession getSession(){
        SqlSessionFactory sqlSessionFactory=null;
        try {
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            Properties resourceAsProperties = Resources.getResourceAsProperties("SqlMapConfig.xml");
//            resourceAsProperties.
            //2.创建 SqlSessionFactory 的构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.使用构建者创建工厂对象 SqlSessionFactory
            sqlSessionFactory = builder.build(in);
            in.close();

        }catch (Exception e){
          e.printStackTrace();
        }
//        return sqlSession=sqlSessionFactory.openSession();
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        MybatilsUtils mybatilsUtils = new MybatilsUtils();
        SqlSession session = mybatilsUtils.getSession();
//        session.e
    }
}
