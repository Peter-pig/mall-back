package com.example.mallusers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@MapperScan("com.example.mallusers.mapper")
public class MallUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUsersApplication.class, args);
    }

}
