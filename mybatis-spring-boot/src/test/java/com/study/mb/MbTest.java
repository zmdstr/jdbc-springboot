package com.study.mb;

import com.study.base.User;
import com.study.mb.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author:
 * @date: 2022/3/8 3:46 下午
 * @description
 */

@SpringBootTest(classes = StartUpApplication.class)
public class MbTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectOne() {
        User user = userMapper.selectOne();
        System.out.println(user);
    }
}