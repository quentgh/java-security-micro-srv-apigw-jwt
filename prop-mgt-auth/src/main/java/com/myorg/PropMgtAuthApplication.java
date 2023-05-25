package com.myorg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.myorg.entities.AppRole;
import com.myorg.enums.RoleName;
import com.myorg.services.AccountService;

@SpringBootApplication
@EnableDiscoveryClient
public class PropMgtAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropMgtAuthApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {
			accountService.addNewRole(new AppRole(RoleName.ADMIN));
			accountService.addNewRole(new AppRole(RoleName.USER));
		};
	}

}
