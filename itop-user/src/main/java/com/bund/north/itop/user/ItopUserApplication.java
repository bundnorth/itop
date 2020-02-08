package com.bund.north.itop.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bund.north.itop.user.mapper")
public class ItopUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItopUserApplication.class, args);
    }

}
