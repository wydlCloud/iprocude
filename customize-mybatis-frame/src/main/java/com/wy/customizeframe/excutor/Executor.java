package com.wy.customizeframe.excutor;

import com.wy.customizeframe.pojo.Configuration;
import com.wy.customizeframe.pojo.MapperStatement;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname Executor
 * @Description 执行器
 * @Date 2020/5/14 11:49 上午
 */
public interface Executor {
    // 查询方法
    public <E> List<E> query(Configuration configuration, MapperStatement
            mappedStatement, Object[] param) throws Exception;

    // 关闭方法
    public void close() throws SQLException;


}
