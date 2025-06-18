package com.trackingnumber.api.Configuration;

import com.trackingnumber.api.entity.Country;
import com.trackingnumber.api.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoInitConfig {
    @Bean
    CommandLineRunner addCountries(CountryRepository repository){
        return args -> {
            if(repository.count() == 0){
                repository.save(new Country("US", "United States"));
                repository.save(new Country("IN", "India"));
                repository.save(new Country("KR", "South Korea"));
                repository.save(new Country("MY", "Malaysia"));
                repository.save(new Country("JP", "Japan"));
                repository.save(new Country("AU", "Australia"));
                repository.save(new Country("BR", "Brazil"));
                repository.save(new Country("FR", "France"));
                repository.save(new Country("CZ", "Czechia"));
            }
        };
    }
}
