package com.coder;

import com.coder.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = {"com.coder.retry.mapper", "com.coder.mapper"})
@MapperScan(basePackages = {"com.coder.retry.mapper"}, basePackageClasses = {UserMapper.class})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
