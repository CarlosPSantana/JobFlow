package com.jobFlow.jobFlow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI jobFlowOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("JobFlow API")
                .version("1.0")
                .description(
                    "API REST para gestionar y hacer seguimiento de candidaturas de empleo."))
            .components(new Components()
                .addSecuritySchemes("basicAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("basic")
                )
            );
    }
}