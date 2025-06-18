package com.trackingnumber.api.repository;

import com.trackingnumber.api.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends MongoRepository<Country, String> {
    Optional<Country> findByCountryCode(String code);
}
