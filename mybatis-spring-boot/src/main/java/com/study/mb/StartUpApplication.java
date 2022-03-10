package com.study.mb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author:
 * @date: 2022/3/8 3:45 下午
 * @description
 */
@SpringBootApplication
@MapperScan(basePackages = "com.study.mb.mapper")
public class StartUpApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartUpApplication.class, args);
    }
}