package com.liutao.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HbEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HbEurekaApplication.class, args);
	}
}
