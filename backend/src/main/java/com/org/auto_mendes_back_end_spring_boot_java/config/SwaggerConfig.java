package com.org.auto_mendes_back_end_spring_boot_java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API Auto Mendes")
                .version("1.0.0")
                .description("Documentação da API Auto Mentes com a OpenAPI"));
    }
}
