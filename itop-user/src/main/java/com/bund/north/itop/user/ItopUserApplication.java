package com.bund.north.itop.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.bund.north.itop.user.mapper")
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ItopUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItopUserApplication.class, args);
    }

}
