package com.example.demo1.infrastructure.adapter.in.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // CAMBIO PARA RENDER: la URL del frontend desplegado se lee de la variable de entorno
    // FRONTEND_URL (sin barra final). En local usa http://localhost:3030 por defecto.
    @Value("${FRONTEND_URL:http://localhost:3030}")
    private String frontendUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                // CAMBIO: se añadió frontendUrl a los orígenes permitidos (localhost se mantiene).
                .allowedOrigins(frontendUrl, "http://localhost:3030", "http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
