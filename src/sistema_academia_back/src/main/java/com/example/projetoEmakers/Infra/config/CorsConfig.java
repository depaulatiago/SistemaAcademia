package com.example.projetoEmakers.Infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite todas as rotas
                        .allowedOrigins("*")// Permite origens específicas (ajuste para seu frontend)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Métodos permitidos

            }
        };
    }
}