package com.study.dbutils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceUtils {

    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/jdbc-springboot?characterEncoding=utf-8");
        config.setUsername("root");
        config.setPassword("admin");
        // 等待连接池分配连接的最大时长（毫秒），超过这个时长还没可用的连接则发生SQLException， 缺省:30秒
        config.setConnectionTimeout(30000);
        // 一个连接idle状态的最大时长（毫秒），超时则被释放（retired），缺省:10分钟
        config.setIdleTimeout(600000);
        // 连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
        config.setMaximumPoolSize(15);
        // 一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired），缺省:30分钟，建议设置比数据库超时时长少30秒，参考MySQL wait_timeout参数（show variables like '%timeout%';）
        config.setMaxLifetime(1800000);

        //创建数据源
        hikariDataSource = new HikariDataSource(config);
    }

    //提供数据源
    public static DataSource getDataSource() {
        return hikariDataSource;
    }
}
