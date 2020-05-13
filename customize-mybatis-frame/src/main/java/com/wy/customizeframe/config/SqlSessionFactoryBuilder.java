package com.wy.customizeframe.config;

import com.wy.customizeframe.pojo.Configuration;

import java.io.InputStream;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname SqlSessionFactoryBuilder
 * @Description TODO
 * @Date 2020/5/12 11:11 下午
 */

public class SqlSessionFactoryBuilder {
    private Configuration configuration;

    public SqlSessionFactoryBuilder() {
        this.configuration = new Configuration();
    }

    public SqlSessionFactory build(InputStream inputStream) {
        return null;
    }

}
