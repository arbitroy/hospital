package com.example.hospital.hospital.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.hospital.hospital"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo(
                    "Hospital Management System API",
                    "This is the API documentation for the Hospital Management System.",
                    "1.0.0",
                    "https://example.com/terms",
                    new Contact("John Doe", "https://example.com", "john@example.com"),
                    "Apache 2.0",
                    "https://example.com/license",
                    Collections.emptyList()));

    }
}