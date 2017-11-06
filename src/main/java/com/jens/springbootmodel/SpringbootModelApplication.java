package com.jens.springbootmodel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.jens.springbootmodel.service")
@EnableScheduling
//@EnableFeignClients
//@EnableDiscoveryClient
public class SpringbootModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootModelApplication.class, args);
	}
}
