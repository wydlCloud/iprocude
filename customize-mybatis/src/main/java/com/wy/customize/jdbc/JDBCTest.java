package com.wy.customize.jdbc;

import com.wy.customize.pojo.User;

import java.sql.*;

/**
 * @author wy
 * @company
 * @Classname JDBCTest
 * @Description
 * JDBC问题总结：
 * 1.数据库连接创建，释放频繁造成系统资源浪费，从而影响了性能
 * 2.sql语句在代码硬编码，造成代码不易于进行维护，实际应用中变化的可能性很大，sql变动需要进行改变java代码
 * 3.使用PreparedStatement向占有位符号传参数存在硬编码，因为sql语句的where条件不一定，可能多也可能少，修改sql还要进行改变代码，系统不易于进行维护
 * 4.对结果集解析存在硬编码(查询列名）,sql变化导致解析代码变化，系统不易于进行维护，如果能将数据库记录封装成pojo对象，解析更方面，面向对象的思想
 *
 * 问题的解决思路
 * 1.数据库频繁创建连接 释放资源：可以使用数据库连接池来解决 eg:c3p0  druid等
 * 2.sql参数存在硬编码：通过配置文件来解决
 * 3.手动解析封装返回结果集：反射、内省
 */

public class JDBCTest {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 通过驱动管理类获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8", "root", "root");
            // 定义sql语句  ？表示占位符
            String sql = "select * from user where username=?";
            // 获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数，第一参数为sql语句中参数的序号 从一开始，第二个参数为设置的参数值
            preparedStatement.setString(1, "张三");
            // 向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            // 遍历结果
            while (resultSet.next()) {
                User user = new User();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                // 封装User
                user.setId(id);
                user.setUsername(username);
                System.out.println(user.getId()+"===="+user.getUsername());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
