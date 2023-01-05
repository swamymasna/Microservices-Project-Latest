package com.swamy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class Ms07AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms07AdminServerApplication.class, args);
	}

}
