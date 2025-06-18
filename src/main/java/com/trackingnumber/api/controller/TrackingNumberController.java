package com.trackingnumber.api.controller;

import com.trackingnumber.api.entity.TrackingNumberRequest;
import com.trackingnumber.api.model.TrackingNumberResponse;
import com.trackingnumber.api.service.TrackingNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Instant;

@RestController
@RequestMapping("/next-tracking-number")
@Validated
public class TrackingNumberController {

    @Autowired
    TrackingNumberService trackingApiService;
    @GetMapping
    public ResponseEntity<TrackingNumberResponse> getTrackingApi (
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam Integer weight,
            @RequestParam String created_at,
            @RequestParam String created_by,
            @RequestParam String customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug
    ) throws ParseException {
        TrackingNumberRequest request = new TrackingNumberRequest();
        request.setOriginCountryId(origin_country_id);
        request.setDestinationCountryId(destination_country_id);
        request.setWeight(BigDecimal.valueOf(weight));
        request.setCreatedAt(Instant.now());
        request.setCustomerId(customer_id);
        request.setCreatedBy(created_by);
        request.setCustomerName(customer_name);
        request.setCustomerSlug(customer_slug);
        return ResponseEntity.ok(trackingApiService.getTrackingNumber(request));
    }
}