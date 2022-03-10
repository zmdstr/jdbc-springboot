package com.study.mybatis;

import com.study.base.User;
import com.study.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void selectOne() throws IOException {
        //************** 第一阶段 **************
        // 第一步，读取 mybatis-config.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 第二步，构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //************** 第二阶段 **************
        // 第三步，打开SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        // 第四步，获取Mapper接口对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //************** 第三阶段 **************
        // 第五步，调用Mapper接口对象的方法操作数据库
        User user = userMapper.selectOne();

        // 第六步，业务处理
        System.out.println(user);
    }

}
