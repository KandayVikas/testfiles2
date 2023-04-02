package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
public class BeanConfig {
}
