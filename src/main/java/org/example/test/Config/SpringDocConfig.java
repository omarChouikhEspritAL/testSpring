package org.example.test.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI()).addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication",createAPIKeyScheme()));
    }

    public Info infoAPI() {
        return new Info().title("Gestion Station de Restaurant")
                .description("TP Le 26-01-2024")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("OMAR CHOUIKH")
                .email("omar.chouikh@esprit.tn")
                .url("https://www.linkedin.com/in/omar-chouikh/");
        return contact;
    }

    @Bean
    public GroupedOpenApi composantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Composant Management API")
                .pathsToMatch("/composant/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi restaurantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Restaurant Management API")
                .pathsToMatch("/restaurant/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi menuPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Menu Management API")
                .pathsToMatch("/menu/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi clientPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Client Management API")
                .pathsToMatch("/client/**")
                .pathsToExclude("**")
                .build();
    }

    private SecurityScheme createAPIKeyScheme(){
        return new SecurityScheme().type(SecurityScheme.Type.HTTP).bearerFormat("JWT").scheme("bearer");
    }
}