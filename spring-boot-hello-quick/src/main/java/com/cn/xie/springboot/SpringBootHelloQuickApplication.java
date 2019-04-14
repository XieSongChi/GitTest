package com.cn.xie.springboot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(value = "com.cn.xie.springboot.mapper") //批量扫描所有的Mapper接口
@SpringBootApplication()
@EnableCaching //开启基于注解的缓存
@EnableRabbit
public class SpringBootHelloQuickApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloQuickApplication.class, args);
    }

}
