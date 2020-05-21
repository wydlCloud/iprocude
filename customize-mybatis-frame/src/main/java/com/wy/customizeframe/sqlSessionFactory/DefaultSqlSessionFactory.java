package com.wy.customizeframe.sqlSessionFactory;

import com.wy.customizeframe.pojo.Configuration;
import com.wy.customizeframe.sqlSession.DefaultSqlSession;
import com.wy.customizeframe.sqlSession.SqlSession;
import com.wy.customizeframe.sqlSessionFactory.SqlSessionFactory;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname DefaultSqlSessionFactory
 * @Description TODO
 * @Date 2020/5/14 11:26 上午
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration){
        this.configuration=configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
