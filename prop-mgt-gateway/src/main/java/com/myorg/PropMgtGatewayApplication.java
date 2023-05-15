package com.myorg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PropMgtGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropMgtGatewayApplication.class, args);
	}

}
