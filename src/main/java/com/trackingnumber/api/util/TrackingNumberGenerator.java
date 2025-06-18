package com.trackingnumber.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

@Component
public class TrackingNumberGenerator {
    private static final Logger log = LoggerFactory.getLogger(TrackingNumberGenerator.class);
    public String generateTrackingNumber(String baseRequest){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(baseRequest.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().encodeToString(hash).substring(0, 16).toUpperCase().replaceAll("[^A-Z0-9]", "");
        } catch(Exception e){
            log.error("Failed to generate the Tracking Number.", e);
            throw new RuntimeException("Failed to generate the Tracking Number.", e);
        }
    }
}
