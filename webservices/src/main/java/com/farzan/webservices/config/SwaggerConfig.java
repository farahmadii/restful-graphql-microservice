package com.farzan.webservices.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig{

    @Bean
    public OpenAPI dogsOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Dog Breeds API")
                        .description("This API returns a list of Dogs").version("1.0")
                        .license(new License().name("Apache2.0").url("http://www.bahbahbah.com/license")))                                   .externalDocs(new ExternalDocumentation()                             .description("dogs wiki documentation")                           .url("http://localhost:8080/dog/wiki"));
    }
}
