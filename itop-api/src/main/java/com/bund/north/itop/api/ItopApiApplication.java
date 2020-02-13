package com.bund.north.itop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hugo0129
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.bund.north.itop.api.clients"})
public class ItopApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItopApiApplication.class, args);
    }

}
