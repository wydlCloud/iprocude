package com.wy.customizeframe.config;

import com.wy.customizeframe.pojo.Configuration;
import com.wy.customizeframe.pojo.MapperStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname XMLMapperConfigBuilder
 * @Description 解析Mapper.xml文件实体类
 */

public class XMLMapperConfigBuilder {

    private Configuration configuration;

    public XMLMapperConfigBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parseMapper(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        /* step1 获取mapper.xml文件的 根标签 的value值  也就是namespace  命名空间 */
        String namespace = rootElement.attributeValue("namespace");
        /* step2 获取关于select的查询方法 */
        List<Element> elementList = rootElement.selectNodes("//select");
        elementList.forEach(x -> {
            String id = x.attributeValue("id");
            String parameterType = x.attributeValue("paramterType");
            String resultType = x.attributeValue("resultType");
            String sql = x.getTextTrim();
            MapperStatement mapperStatement = new MapperStatement();
            mapperStatement.setId(id);
            mapperStatement.setParamterType(parameterType);
            mapperStatement.setResultType(resultType);
            mapperStatement.setSql(sql);
            // 定义key值  key 为statementId 由namespace+"."+id 构成
            String key = namespace + "." + id;
            configuration.getMappedStatementMap().put(key, mapperStatement);
        });
    }


}
