package com.swamy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Ms05ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms05ApiGatewayApplication.class, args);
	}

}
