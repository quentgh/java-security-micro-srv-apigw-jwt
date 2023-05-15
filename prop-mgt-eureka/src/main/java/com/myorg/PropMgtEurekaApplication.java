package com.myorg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PropMgtEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropMgtEurekaApplication.class, args);
	}

}
