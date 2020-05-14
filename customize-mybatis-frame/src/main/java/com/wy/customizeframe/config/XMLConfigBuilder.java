package com.wy.customizeframe.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wy.customizeframe.io.Resources;
import com.wy.customizeframe.pojo.Configuration;
import com.wy.customizeframe.pojo.MapperStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname XMLConfigBuilder
 * @Description 解析sqlMapConfig.xml 实体类
 * @Date 2020/5/13 5:29 下午
 */

public class XMLConfigBuilder {
    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration = new Configuration();
    }

    /* 解析输入流，也就是解析sqlMapConfig.xml ，解析xml在此使用dom4j来解析 */
    public Configuration parseConfig(InputStream inputStream) throws DocumentException, PropertyVetoException {
        /* step1 通过dom4j读取字节流，转换为document类型*/
        Document document = new SAXReader().read(inputStream);
        /* step2 获取xml的根标签 sqlMapConfig.xml的<configuration> 标签*/
        Element rootElement = document.getRootElement();
        /* step3 获取所有的关于property的标签，其实在此xml中的主要定义的就是数据源 */
        List<Element> elementList = rootElement.selectNodes("//property");
        // 在此定义属性类，主要用于存储属性,把数据源的信息存储到properties属性实体类中
        Properties properties = new Properties();
        elementList.forEach(x -> {
            String name = x.attributeValue("name");
            String value = x.attributeValue("value");
            properties.put(name, value);
        });
        // 既然获取到了数据源信息，这个时候就要对数据源信息进行管理
        /* step4 使用c3p0 连接池进行管理数据源以及数据库连接，使用c3po连接池进行存储 */
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        comboPooledDataSource.setUser(properties.getProperty("user"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));
        configuration.setDataSource(comboPooledDataSource);
        /**
         * 在上面把数据源的信息已经解析完成了，但是xml中引入的<mapper resource="mapper.xml"></mapper> 的配置并没有进行解析呢
         * 下面进行解析这个配置
         * ------------------------------------------------------------------------------------
         */
        /* step5  获取mapper标签的所有元素*/
        List<Element> mapperList = rootElement.selectNodes("//mapper");
        // 因为可能存在多个mapper标签，其实mapper标签 表示的就是mapper.xml的绝对路径，可以找到相关mapper.xml，可以进行解析
        XMLMapperConfigBuilder xmlMapperConfigBuilder=new XMLMapperConfigBuilder(configuration);
        mapperList.forEach(x->{
            // 获取到的就是mapper.xml的路径
            String mapperPath = x.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
            // 获取到mapper.xml的字节流 通过此实体类的此方法进行解析，并将进行赋值到
            try {
                xmlMapperConfigBuilder.parseMapper(resourceAsStream);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });
        return configuration;
    }
}
