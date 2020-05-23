package com.wy.factoryTransfer.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname TransactionManager
 * @Description 事务管理类
 */

public class TransactionManager {
    private ConnectionUtils connectionUtils;

    // 通过这种方式来进行注入到事务管理类中
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    private static TransactionManager transactionManager = new TransactionManager();

    public static TransactionManager getInstance() {
        return transactionManager;
    }
    // 开始事务
    public void beginTransaction() throws SQLException {
        Connection currentThreadConn = connectionUtils.getCurrentThreadConn();
        currentThreadConn.setAutoCommit(false);
    }

    // 提交事务
    public void commit() throws SQLException {
        connectionUtils.getCurrentThreadConn().commit();
    }

    // 回滚事务
    public void rollback() throws SQLException {
        connectionUtils.getCurrentThreadConn().rollback();
    }

}
