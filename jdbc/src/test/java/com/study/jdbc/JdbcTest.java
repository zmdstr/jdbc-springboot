package com.study.jdbc;


import com.study.base.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcTest {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 加载mysql数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc-springboot?characterEncoding=utf-8", "root", "admin");
            // sql语句
            String sql = "select * from user where userName = ?";
            // 预处理statement
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数，针对sql中占位符中
            preparedStatement.setString(1, "张三");
            // 发起查询
            resultSet = preparedStatement.executeQuery();
            User user = new User();
            // 遍历查询结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                int userAge = resultSet.getInt("userAge");
                int sex = resultSet.getInt("sex");
                String userAddress = resultSet.getString("userAddress");
                // 封装结果为User对象
                user.setId(id);
                user.setUserName(userName);
                user.setSex(sex);
                user.setUserAge(userAge);
                user.setUserAddress(userAddress);
            }
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
