package com.wy.customTransfer.mapper.impl;

import com.wy.customTransfer.mapper.AccountMapper;
import com.wy.customTransfer.pojo.Account;
import com.wy.customTransfer.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname AccountMapperImpl
 * @Description 账号mapper实现类
 */

public class JDBCAccountMapperImpl implements AccountMapper {
    private ConnectionUtils connectionUtils=new ConnectionUtils();

    @Override
    public Account queryAccountByCardNo(String cardNo) throws SQLException {
        // 从数据库连接池获取连接
        Connection currentThreadConn = connectionUtils.getCurrentThreadConn();
        // 获取连接可以直接操作数据库  定义sql语句
        String sql = "select * from account where card_no=?";
        PreparedStatement preparedStatement = currentThreadConn.prepareStatement(sql);
        preparedStatement.setString(1, cardNo);
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = new Account();
        while (resultSet.next()) {
            account.setCardNo(resultSet.getString("card_no"));
            account.setMoney(resultSet.getInt("money"));
            account.setName(resultSet.getString("name"));
        }
        resultSet.close();
        preparedStatement.close();
        currentThreadConn.close();
        return account;
    }

    @Override
    public int updateAccountByCardNo(Account account) throws SQLException {
        Connection currentThreadConn = connectionUtils.getCurrentThreadConn();
        String sql = "update account set money=? where card_no=?";
        PreparedStatement preparedStatement = currentThreadConn.prepareStatement(sql);
        preparedStatement.setInt(1, account.getMoney());
        preparedStatement.setString(2, account.getCardNo());
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        currentThreadConn.close();
        return i;
    }
}
