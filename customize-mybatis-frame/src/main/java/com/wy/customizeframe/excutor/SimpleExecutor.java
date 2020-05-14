package com.wy.customizeframe.excutor;

import com.wy.customizeframe.pojo.Configuration;
import com.wy.customizeframe.pojo.MapperStatement;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname SimpleExcutor
 * @Description 执行器的简单实现类
 * @Date 2020/5/14 11:49 上午
 */

public class SimpleExecutor implements Executor {

    @Override
    public <E> List<E> query(Configuration configuration, MapperStatement mappedStatement, Object[] param) throws Exception {
        return null;
    }

    @Override
    public void close() throws SQLException {

    }
}
