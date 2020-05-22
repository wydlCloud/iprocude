package com.wy.factoryTransfer.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wy
 * desc:
 * 通过线程局部变量来进行存储当前线程的共享变量，只保存当前线程的数据
 *
 * 因为事务的控制是维护在同一个connection中的，如果两个insert操作，使用两个connection的话，这种情况下肯定是不能够进行事务管理的
 *
 * 所以connection.close()关闭的情况下，这个时候，数据库连接就会失效，释放连接，释放之后，再次执行新的操作，就需要获取新的连接，这种情况下
 * 就不能够保证事务了，其实保证事务的原理 就是，同一个数据库连接，一直进行操作，因为一条链路是同一个线程在执行，所以让当前线程数据库的执行使用同一个个连接即可
 * 就可以进行进一步进行保证事务，因为事务在jdbc是在dao层级别的，所以，针对于目前现有业务的话，要提取到service层进行事务管理，
 * 因为service层的一个业务方法，可能会操作很多次的dao层，而且要使用同一个数据库链接，这个时候，需要采用的就是数据库连接和线程建立绑定关系
 * 因为线程是同一个，这种情况下，就可以更好的进行事务管理了。
 *
 * 后面要继续记一下事务是如何进行管理的，如何来实现的事务，并且自己手动实现一下，才会记录的更加清晰，因为这些内容，思想都是大同小异的，
 * 但是那些大师在实现的时候，加入了很多好的设计思想在其中，这是真正值得去借鉴的。
 *
 *
 * 事务如何进行管理呢？
 *
 *
 *JDBC 其实本事就提供了，事务提交，事务回滚机制，默认的情况下，是在数据量连接创建之后，数据库连接关闭时自动提交事务，如果想手动进行控制，要进行手动进行管理
 * 设置手动提交
 * connection.setAutoCommit(false)
 * 提交
 * connection.commit();
 * 回滚
 * connection.rollback();
 */
public class ConnectionUtils {

    private ConnectionUtils() {

    }

    private static ConnectionUtils connectionUtils = new ConnectionUtils();

    public static ConnectionUtils getInstance() {
        return connectionUtils;
    }


    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>(); // 存储当前线程的连接

    /**
     * 从当前线程获取连接
     */
    public Connection getCurrentThreadConn() throws SQLException {
        /**
         * 判断当前线程中是否已经绑定连接，如果没有绑定，需要从连接池获取一个连接绑定到当前线程
          */
        Connection connection = threadLocal.get();
        if(connection == null) {
            // 从连接池拿连接并绑定到线程
            connection = DruidUtils.getInstance().getConnection();
            // 绑定到当前线程
            threadLocal.set(connection);
        }
        return connection;

    }
}
