package br.com.AcacioH.gestaodeconvidados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
public class Swagger2Config {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo())
                // https://www.baeldung.com/spring-boot-swagger-jwt
                .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("API de Gestão de Convidados")
                .description("API para estudo e participação em processos seletivos")
                .contact(new Contact("Acácio Afonso", "https://github.com/AcacioH", "acaciohenriqueafonso@gmail.com")).build();
    }

    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }
}