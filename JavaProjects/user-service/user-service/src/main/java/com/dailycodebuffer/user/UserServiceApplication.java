package com.dailycodebuffer.user;

import com.dailycodebuffer.user.VO.RestTemplateVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced //if multiple services are connected for the service-registry it will load balance requests for us
	public RestTemplate restTemplate(){

        return new RestTemplate();
	}
}
