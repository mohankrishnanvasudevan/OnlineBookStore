package com.techconative.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI myOpenAPI() {
    

    Info info = new Info()
        .title("OnlineBookStore")
        .version("1.0");

    return new OpenAPI().info(info);
  }
}

