package com.springboot.jobapp.config;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Job Application",
                version = "1.0.0",
                description = "REST API for managing companies, jobs, and reviews."


        )
)
public class OpenApiConfig {
}

