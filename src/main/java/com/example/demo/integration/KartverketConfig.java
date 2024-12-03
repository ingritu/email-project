package com.example.demo.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class KartverketConfig {

    @Bean
    public RestClient KartverketRestClient() {
        return RestClient.builder()
                .baseUrl("https://ws.geonorge.no/kommuneinfo/v1/")
                .build();
    }
}
