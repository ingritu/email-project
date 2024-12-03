package com.example.demo.resource;

import com.example.demo.service.CountyService;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/county/")
public class CountyResource {

    private final CountyService countyService;

    public CountyResource(CountyService countyService) {
        this.countyService = countyService;
    }

    @GetMapping("{countyNumber}")
    public ResponseEntity<String> getCounty(@PathVariable @NotNull @Digits(integer = 2, fraction = 0) String countyNumber) {
        return ResponseEntity.ok(countyService.findCounty(countyNumber));
    }
}
