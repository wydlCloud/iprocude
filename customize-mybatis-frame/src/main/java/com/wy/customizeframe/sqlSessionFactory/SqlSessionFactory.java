package com.wy.customizeframe.sqlSessionFactory;

import com.wy.customizeframe.sqlSession.SqlSession;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname SqlSessionFactory
 * @Description 工厂主要是造SqlSession对象
 * @Date 2020/5/13 12:35 上午
 */

public interface SqlSessionFactory {

    public SqlSession openSession();
}
