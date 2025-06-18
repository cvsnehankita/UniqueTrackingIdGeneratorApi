package com.trackingnumber.api.repository;

import com.trackingnumber.api.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CountryRepository extends MongoRepository<Country, String> {}
