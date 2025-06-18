package com.trackingnumber.api.repository;

import com.trackingnumber.api.entity.TrackingNumberRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingNumberRepository extends MongoRepository<TrackingNumberRequest, String> {
}
