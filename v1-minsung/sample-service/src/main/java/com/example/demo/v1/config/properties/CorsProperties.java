package com.example.demo.v1.config.properties;

import com.example.demo.v1.config.properties.allowed.CorsAllowedProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "app.webapp.cors")
@ConfigurationPropertiesBinding
public record CorsProperties(
        @NestedConfigurationProperty CorsAllowedProperties allowed,
        String[] exposedHeaders
) {
    public CorsProperties {
        if (allowed == null) {
            allowed = new CorsAllowedProperties(null, null, null);
        }

        if (exposedHeaders == null || exposedHeaders.length == 0) {
            exposedHeaders = new String[] {"*"};
        }
    }
}