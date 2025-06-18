package com.trackingnumber.api.service;

import com.trackingnumber.api.entity.Country;
import com.trackingnumber.api.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CountryService {
    private static final Logger log = LoggerFactory.getLogger(CountryService.class);
    @Autowired
    CountryRepository repository;
    public CountryService(CountryRepository countryRepository) {
        this.repository = countryRepository;
    }

    public Country saveCountryCode(Country request) {
        return repository.save(request);
    }

    public Country getCountryByCode(String countrCode) {
        log.info("Getting country details for country code={}", repository.findByCountryCode(countrCode));
        return repository.findByCountryCode(countrCode)
                .orElseThrow(() -> new NoSuchElementException("Country code not found: " + countrCode));
    }
}
