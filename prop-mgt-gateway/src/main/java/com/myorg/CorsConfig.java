package com.myorg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import jakarta.ws.rs.HttpMethod;

@Configuration
public class CorsConfig {
    @Bean
    public CorsWebFilter corsFilter() {
        return new CorsWebFilter(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
        config.addAllowedHeader(HttpMethod.GET);
        config.addAllowedHeader(HttpMethod.DELETE);
        config.addAllowedHeader(HttpMethod.POST);
        config.addAllowedHeader(HttpMethod.PUT);
        config.addAllowedHeader(HttpMethod.OPTIONS);

        source.registerCorsConfiguration("/**", config);
        return source;
    }

}
