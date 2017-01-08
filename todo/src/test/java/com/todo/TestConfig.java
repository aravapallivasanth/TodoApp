package com.todo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages="com.todo")
@Configuration
@EnableAutoConfiguration
public class TestConfig {
	
	@Bean
    public TodoController todoController() {
        return new TodoController();
    }

}
