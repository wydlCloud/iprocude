package com.wy.customizeframe.sqlSessionFactory;

import com.wy.customizeframe.config.XMLConfigBuilder;
import com.wy.customizeframe.pojo.Configuration;
import com.wy.customizeframe.sqlSessionFactory.DefaultSqlSessionFactory;
import com.wy.customizeframe.sqlSessionFactory.SqlSessionFactory;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname SqlSessionFactoryBuilder
 * @Description 解析xml文件，并进行管理
 * @Date 2020/5/12 11:11 下午
 */

public class SqlSessionFactoryBuilder {
    private Configuration configuration;

    public SqlSessionFactoryBuilder() {
        this.configuration = new Configuration();
    }

    // 解析sqlMapConfig.xml 字节流 并且返回sqlSessionFactory
    public SqlSessionFactory build(InputStream inputStream) throws PropertyVetoException, DocumentException {
        /* step1 解析xml文件，可以获取到配置信息（数据源信息和mapper标签的所有的信息） */
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(inputStream);
        /* step2 创建sqlSessionFactory，并通过sqlSessionFactory */
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        return sqlSessionFactory;
    }

}
