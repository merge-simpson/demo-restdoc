package com.example.demo.v1.config;

import com.example.demo.v1.config.properties.CorsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebApplicationConfig implements WebMvcConfigurer {

    protected final CorsProperties corsProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .exposedHeaders(corsProperties.exposedHeaders())
                .allowedHeaders(corsProperties.allowed().headers())
                .allowedMethods(corsProperties.allowed().methods())
                .allowedOrigins(corsProperties.allowed().origins());
    }
}