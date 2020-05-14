package com.wy.customizeframe.sqlSession;

import com.wy.customizeframe.excutor.Executor;
import com.wy.customizeframe.excutor.SimpleExecutor;
import com.wy.customizeframe.pojo.Configuration;
import com.wy.customizeframe.pojo.MapperStatement;

import java.util.List;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname DeafalutSqlSession
 * @Description TODO
 * @Date 2020/5/14 11:37 上午
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
}
