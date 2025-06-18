package com.trackingnumber.api;

import com.trackingnumber.api.entity.TrackingNumberRequest;
import com.trackingnumber.api.model.TrackingNumberResponse;
import com.trackingnumber.api.repository.TrackingNumberRepository;
import com.trackingnumber.api.service.TrackingNumberService;
import com.trackingnumber.api.util.TrackingNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.Instant;

import static org.mockito.Mockito.when;
import java.util.UUID;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

public class TrackingNumberServiceTest {

    @InjectMocks
    private TrackingNumberService trackingNumberService;
    @Mock
    private TrackingNumberRepository trackingNumberRepository;
    @Mock
    private TrackingNumberGenerator trackingNumberGenerator;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGetTrackingNumber_success() {
        TrackingNumberRequest request = new TrackingNumberRequest();
        request.setOriginCountryId("IN");
        request.setDestinationCountryId("US");
        request.setWeight(BigDecimal.valueOf(50));
        request.setCreatedAt(Instant.now());
        request.setCustomerId(UUID.randomUUID().toString());
        request.setCreatedBy("TestUser");
        request.setCustomerName("RedBox");
        request.setCustomerSlug("redbox");

        when(trackingNumberRepository.save(any(TrackingNumberRequest.class))).thenReturn(request);
        when(trackingNumberGenerator.generateTrackingNumber(any(String.class))).thenReturn("TRACK123456");

        TrackingNumberResponse response = trackingNumberService.getTrackingNumber(request);

        assertNotNull(response);
        assertEquals("TRACK123456", response.getTrackingNumber());
        assertEquals(request.getCreatedAt(), response.getCreatedAt());
    }
}
