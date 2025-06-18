package com.trackingnumber.api.controller;

import com.trackingnumber.api.entity.Country;
import com.trackingnumber.api.model.CountryCode;
import com.trackingnumber.api.service.CountryService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
@Validated
public class CountryController  {
    private static final Logger log = LoggerFactory.getLogger(CountryController.class);
    @Autowired
    CountryService countryService;
    @PostMapping("/add")
    public ResponseEntity<Country> addCountryCodes (@Valid @RequestBody Country request){
        Country saved = countryService.saveCountryCode(request);
        log.info("Saving country details for country code: {}", request.getCountryCode());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping("/get/{countryCode}")
    public ResponseEntity<CountryCode> getCountryDetails (@PathVariable String countryCode){
        Country country = countryService.getCountryByCode(countryCode.toUpperCase());
        if(country == null){
            log.warn("Country not found for code: {}", countryCode);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("Fetching country details for country code: {}", countryCode );
        return ResponseEntity.ok(new CountryCode(country.getCountryCode(), country.getCountryName()));
    }
}
