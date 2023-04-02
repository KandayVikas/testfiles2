package com.dailycodebuffer.CloudGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerResilience4JFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.DispatcherHandler;

//@ConditionalOnClass({DispatcherHandler.class,ReactiveResilience4JAutoConfiguration.class})
@SpringBootApplication
public class CloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

//	@Bean
//	public Customizer<SpringCloudCircuitBreakerResilience4JFilterFactory> defaultCustomizer(){
//
//		return factory-> factory.newConfig(
//				id -> new Resil
//		)
//	}
}
