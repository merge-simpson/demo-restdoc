package com.example.demo.v1.config.properties.allowed;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@ConfigurationPropertiesBinding
public record CorsAllowedProperties(
        String[] headers,
        String[] methods,
        String[] origins
) {
    public CorsAllowedProperties {
        if (origins == null || origins.length == 0) {
            origins = new String[0];
        }
        if (headers == null || headers.length == 0) headers = new String[] {"*"};
        if (methods == null || methods.length == 0) methods = new String[] {"*"};
    }
}