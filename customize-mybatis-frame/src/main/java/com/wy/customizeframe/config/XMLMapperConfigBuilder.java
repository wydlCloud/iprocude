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
 * @company 唯小宝(江苏)网络科技
 * @Classname XMLMapperConfigBuilder
 * @Description 解析Mapper.xml文件实体类
 * @Date 2020/5/13 5:52 下午
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
        String namespace = rootElement.attributeValue("mapper");
        /* step2 获取关于select的查询方法 */
        List<Element> elementList = rootElement.selectNodes("//select");
        elementList.forEach(x -> {
            String id = x.attributeValue("id");
            String parameterType = x.attributeValue("parameterType");
            Class<?> param = getClassType(parameterType);
            String resultType = x.attributeValue("resultType");
            Class<?> result = getClassType(resultType);
            String sql = x.getTextTrim();
            MapperStatement mapperStatement = new MapperStatement();
            mapperStatement.setId(id);
            mapperStatement.setParamterType(param);
            mapperStatement.setResultType(result);
            mapperStatement.setSql(sql);
            // 定义key值  key 为statementId 由namespace+"."+id 构成
            String key = namespace + "." + id;
            configuration.getMappedStatementMap().put(key, mapperStatement);
        });
    }

    /**
     * 功能描述: 把字符串入参通过反射转化为类文件
     *
     * @Param:
     * @Return:
     * @Author: wy
     * @Date: 2020/5/14 11:18 上午
     * 其他修改人：
     * 修改时间: 2020/5/14 11:18 上午
     **/
    private Class<?> getClassType(String paramterType) {
        Class<?> aClass = null;
        try {
            aClass = Class.forName(paramterType);
            // 通过此方式可以实例化class类
            // Object o = aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return aClass;
    }

}
