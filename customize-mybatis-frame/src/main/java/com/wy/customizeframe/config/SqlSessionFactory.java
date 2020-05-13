package com.wy.customizeframe.config;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname SqlSessionFactory
 * @Description TODO
 * @Date 2020/5/13 12:35 上午
 */

public interface SqlSessionFactory {
    public SqlSession openSession();
}
