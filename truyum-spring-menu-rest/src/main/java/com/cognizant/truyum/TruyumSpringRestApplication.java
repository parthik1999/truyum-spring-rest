package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TruyumSpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumSpringRestApplication.class, args);
	}

}
