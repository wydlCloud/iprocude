package com.wy.customizeframe.sqlSessionFactory;

import com.wy.customizeframe.sqlSession.SqlSession;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname SqlSessionFactory
 * @Description 工厂主要是造SqlSession对象
 */

public interface SqlSessionFactory {

    public SqlSession openSession();
}
