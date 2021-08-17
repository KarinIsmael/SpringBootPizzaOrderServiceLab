package com.example.springbootpizzademo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//för att kunna läsa dokumentaionen för programmet
//url som används för att få fram dokumentationen:   localhost:8080/v3/api-docs
//url för att få dokumentet med grafiskt gränssnitt:  localhost:8080/swagger-ui/
@Configuration
public class SpringfoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.any())
                .build();
    } //ovan har inga begränsningar på vad som ska implementeras.
}
