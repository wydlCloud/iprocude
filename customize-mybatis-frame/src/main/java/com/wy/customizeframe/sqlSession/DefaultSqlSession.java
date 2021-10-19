package com.wy.customizeframe.sqlSession;

import com.wy.customizeframe.excutor.Executor;
import com.wy.customizeframe.excutor.SimpleExecutor;
import com.wy.customizeframe.pojo.Configuration;
import com.wy.customizeframe.pojo.MapperStatement;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.List;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname DeafalutSqlSession
 * @Description TODO
 */

public class DefaultSqlSession implements SqlSession {
    private static  final  int ZERO=0;
    private Configuration configuration;

    private Executor executor=new SimpleExecutor();
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    // 泛型E 在集合中使用，因为E 表示的元素  Element
    // 在这里解释下为什么要传入statementId和params
    // 因为statementId是作为可识别sql 的唯一标识，通过此属性，可以确定
    @Override
    public <E> List<E> selectList(String statementId, Object... param) throws Exception {
        MapperStatement mapperStatement = configuration.getMappedStatementMap().get(statementId);
        List<Object> objectList = executor.query(configuration, mapperStatement, param);
        return (List<E>) objectList;
    }

    // 泛型T 表示的Java类型
    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {
        List<Object> objectList = this.selectList(statementId, params);
        if (objectList.size()!=1){
            throw new RuntimeException("query result is empty OR query multiple");
        }
        return (T) objectList.get(ZERO);
    }
    // 可以理解为生成mapper代理类的方法
    @Override
    public <T> T getMapper(Class<?> clazz) {
        // 使用java动态代理来为mapper接口生成代理对象，并返回
        Object proxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 底层其实都是去执行jdbc代码 根据不同的情况，，来调用selectList 和selectOne即可
                // 准备参数 1. statementId  2.方法名
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String statementId=className+"."+methodName;
                // 准备参数 param：args
                // 获取返回值类型
                Type genericReturnType = method.getGenericReturnType();
                if (genericReturnType instanceof ParameterizedType){
                    // 如果是参数类型，则返回的是数组
                    List<Object> objectList = selectList(statementId, args);
                    return objectList;
                }
                return selectOne(statementId,args);
            }
        });
        addClassToDisk(clazz.getName(), clazz,"/Users/wy/project/OWN/iprocude/customize-mybatis/src/main/resources/$Proxy1.class");
        return (T) proxyInstance;
    }
    /**
     * 用于生产代理对象的字节码，并将其保存到硬盘上
     * @param className
     * @param cl
     * @param path
     */
    private static void addClassToDisk(String className, Class<?> cl, String path) {
        //用于生产代理对象的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(className, cl.getInterfaces());
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            //将代理对象的class字节码写到硬盘上
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
