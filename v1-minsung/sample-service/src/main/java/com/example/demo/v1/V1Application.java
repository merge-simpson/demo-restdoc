package com.example.demo.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = V1Application.PKG4GROUP)
@ConfigurationPropertiesScan(basePackages = V1Application.PKG4GROUP)
public class V1Application {
    public static final String PKG4GROUP = "com.example";
    public static void main(String[] args) {
        SpringApplication.run(V1Application.class, args);
    }
}
