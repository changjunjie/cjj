package com.coder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 以下两种方式可以配置mapper包，改为在DBConfig.java中配置mapper
// @MapperScan(basePackages = {"com.coder.retry.mapper", "com.coder.mapper"})
// @MapperScan(basePackages = {"com.coder.retry.mapper"}, basePackageClasses = {UserMapper.class})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
