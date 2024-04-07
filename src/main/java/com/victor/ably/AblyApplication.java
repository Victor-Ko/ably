package com.victor.ably;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = AblyApplication.class)
@SpringBootApplication
public class AblyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AblyApplication.class, args);
    }

}
