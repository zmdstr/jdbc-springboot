package com.study.ms;

import com.study.base.User;
import com.study.ms.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-beans.xml"})
public class MsTest {

    @Autowired
    private UserMapper userMapper;

	@Test
    public void selectOne() {
        User user = userMapper.selectOne();
        System.out.println(user);
    }

}
