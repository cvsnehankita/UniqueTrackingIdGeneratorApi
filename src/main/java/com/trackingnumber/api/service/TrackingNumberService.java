package com.trackingnumber.api.service;

import com.trackingnumber.api.entity.TrackingNumberRequest;
import com.trackingnumber.api.model.TrackingNumberResponse;
import com.trackingnumber.api.repository.TrackingNumberRepository;
import com.trackingnumber.api.util.TrackingNumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingNumberService {
    private static final Logger log = LoggerFactory.getLogger(TrackingNumberService.class);
    @Autowired
    TrackingNumberGenerator trackingNumberGenerator;
    @Autowired
    TrackingNumberRepository repository;
    public void addTrackingRequest(TrackingNumberRequest request){
        repository.save(request);
    }
    public TrackingNumberResponse getTrackingNumber(TrackingNumberRequest request){
        addTrackingRequest(request);
        return new TrackingNumberResponse(generateTrackingNumber(request), request.getCreatedAt());
    }
    private String generateTrackingNumber(TrackingNumberRequest request){
        String baseRequest = request.getOriginCountryId()
                + request.getDestinationCountryId()
                + request.getWeight()
                + request.getCreatedAt()
                + request.getCustomerId()
                + request.getCustomerName()
                + request.getCustomerSlug();
        log.info("Generating tracking number for customerId={}", request.getCustomerId());
        return trackingNumberGenerator.generateTrackingNumber(baseRequest);
    }
}
