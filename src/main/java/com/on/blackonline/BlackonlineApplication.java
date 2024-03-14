package com.on.blackonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class BlackonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackonlineApplication.class, args);
	}

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Blackonline API")
                        .version("1.0")
                        .description("Documentation Blackonline API v1.0"));
    }
}
