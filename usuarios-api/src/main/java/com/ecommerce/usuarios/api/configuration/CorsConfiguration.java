package com.ecommerce.usuarios.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("GET", "PUT", "POST", "DELETE");
    }

}
