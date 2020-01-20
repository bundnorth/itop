package com.bund.north.itop.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bund.north.itop.dao.mapper")
public class ItopDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItopDaoApplication.class, args);
	}

}
