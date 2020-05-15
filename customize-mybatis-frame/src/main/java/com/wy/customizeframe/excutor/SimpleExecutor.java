package com.wy.customizeframe.excutor;

import com.google.common.collect.Lists;
import com.wy.customizeframe.config.BoundSql;
import com.wy.customizeframe.pojo.Configuration;
import com.wy.customizeframe.pojo.MapperStatement;
import com.wy.customizeframe.utils.GenericTokenParser;
import com.wy.customizeframe.utils.ParameterMapping;
import com.wy.customizeframe.utils.ParameterMappingTokenHandler;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.List;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname SimpleExcutor
 * @Description 执行器的简单实现类
 * @Date 2020/5/14 11:49 上午
 */

public class SimpleExecutor implements Executor {


    // 执行器，主要是封装sqlSession的底层jdbc的执行，那当然包括参数设置，jdbc执行，返回结果封装
    @Override
    public <E> List<E> query(Configuration configuration, MapperStatement mappedStatement, Object[] param) throws Exception {
        /* step1  注册驱动，获取数据库连接*/
        Connection connection = configuration.getDataSource().getConnection();
        /* step2  获取sql语句  select * from user where id = #{id} and username =#{username}
         *         转换sql语句   select * from user where id = ？ and username = ？
         *         转换的过程中，还需要对#{}里面的值进行解析存储 */
        String sql = mappedStatement.getSql();
        // 解析sql ，通过getBoundSql()方法
        BoundSql boundSql = getBoundSql(sql);
        /* step3   获取预处理对象*/
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());
        /* step4   设置参数 */
        //获取到参数的全路径
        String paramterType = mappedStatement.getParamterType();
        Class<?> paramsType=null;
        if (StringUtils.isNotBlank(paramterType)){
            paramsType = getClassType(paramterType);
        }
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
        for (int i = 0; i < parameterMappingList.size(); i++) {
            ParameterMapping parameterMapping = parameterMappingList.get(i);
            String content = parameterMapping.getContent();
            // 通过反射进行根据获取到的content  context其实就是#{id} 这里面的id名称，通过该名称就可以把实例中的相对应的属性值取出来，通过反射
            //反射
            Field declaredField = paramsType.getDeclaredField(content);
            //暴力访问
            declaredField.setAccessible(true);
            // 获取输入参数的第一个参数
            Object o = declaredField.get(param[0]);
            preparedStatement.setObject(i + 1, o);
        }
        /* step5   执行sql */
        ResultSet resultSet = preparedStatement.executeQuery();
        /* step6   结果返回值封装 通过反射和内省,获取到参数就要进行封装返回值到实体了 */
        // 获取返回值类型
        String resultType = mappedStatement.getResultType();
        Class<?> resultTypes=null;
        if (StringUtils.isNotBlank(resultType)){
            resultTypes = getClassType(resultType);
        }
        List<Object> objectList = Lists.newArrayList();
        while (resultSet.next()) {
            Object o = resultTypes.newInstance();
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                Object value = resultSet.getObject(columnName);

                //使用反射或者内省，根据数据库表和实体的对应关系，完成封装
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultTypes);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(o, value);
            }
            objectList.add(o);
        }
        return (List<E>) objectList;
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
    /**
     * 完成对#{}的解析工作：1.将#{}使用？进行代替，2.解析出#{}里面的值进行存储
     *
     * @param sql
     * @return
     */
    private BoundSql getBoundSql(String sql) {
        //标记处理类：配置标记解析器来完成对占位符的解析处理工作
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        //解析出来的sql
        String parseSql = genericTokenParser.parse(sql);
        //#{}里面解析出来的参数名称
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();

        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
        return boundSql;

    }

}
