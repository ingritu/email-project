package com.example.demo.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CountyService {

    private final RestClient kartverketClient;

    public CountyService(RestClient kartverketClient) {
        this.kartverketClient = kartverketClient;
    }

    public String findCounty(String county) {
        return kartverketClient.get()
                .uri("/fylker/" + county)
                .accept(MediaType.ALL)
                .retrieve()
                .body(String.class);
    }
}
