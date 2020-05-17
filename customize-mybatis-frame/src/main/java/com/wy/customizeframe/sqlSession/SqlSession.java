package com.wy.customizeframe.sqlSession;

import com.wy.customizeframe.pojo.Configuration;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname SqlSession
 * @Description
 * sqlSession，其实在底层是封装了jdbc执行的底层方法，让起来执行，所以这里理解为会话对象
 * 通过此会话对象来进行操作jdbc的执行操作
 * @Date 2020/5/13 12:35 上午
 */

public interface SqlSession {
    /**
     * 查询单条数据
     */
    public <E> List<E> selectList(String statementId, Object... param) throws
            Exception;

    /**
     * 查询多条数据
     */
    public <T> T selectOne(String statementId, Object... params) throws
            Exception;

    /**
     * 获取mapper的映射类，通过此方法，可以直接调用mapper中的方法，可以直接执行sql
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<?> clazz);
}
