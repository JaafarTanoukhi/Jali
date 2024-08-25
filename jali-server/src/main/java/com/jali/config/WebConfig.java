package com.jali.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow CORS on all paths
                .allowedOriginPatterns("*") // Allow specific origins, e.g., http://example.com
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
                .allowedHeaders("*") // Allow any headers
                .allowCredentials(true) // Allow credentials (cookies, etc.)
                .maxAge(3600); // Cache the pre-flight response for 1 hour
    }
}
