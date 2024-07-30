package com.example.loggingzi.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Logging API",version = "1.0", description = "API za logiranje poruka"))
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public GroupedOpenApi publicApi(){
		return GroupedOpenApi.builder()
				.group("public")
				.pathsToMatch("/api/logging/**")
				.build();
	}
}
