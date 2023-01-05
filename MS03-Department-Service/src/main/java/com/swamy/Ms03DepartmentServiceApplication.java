package com.swamy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Ms03DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms03DepartmentServiceApplication.class, args);
	}

}
