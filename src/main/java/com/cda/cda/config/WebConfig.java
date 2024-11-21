package com.cda.cda.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configuração para servir o diretório de uploads
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/"); // Caminho físico para os uploads
    }
}
