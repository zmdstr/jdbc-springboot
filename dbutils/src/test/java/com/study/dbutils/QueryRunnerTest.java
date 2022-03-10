package com.study.dbutils;

import com.study.base.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;


public class QueryRunnerTest {

    /**
     * 查找单条记录
     * @throws SQLException
     */
    @Test
    public void find() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where id=?";
        User user = (User) runner.query(sql, new BeanHandler(User.class), 1);
        System.out.println(user);
    }
}
