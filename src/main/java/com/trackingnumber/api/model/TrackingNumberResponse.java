package com.trackingnumber.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Getter
@Setter
public class TrackingNumberResponse {

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Instant  createdAt;
    public TrackingNumberResponse(){}
    public TrackingNumberResponse(String trackingNumber, Instant createdAt) {
        this.trackingNumber = trackingNumber;
        this.createdAt = createdAt;
    }
    public String getTrackingNumber() {
        return trackingNumber;
    }
    public void setTrackingNumber(String tracking_number) {
        this.trackingNumber = trackingNumber;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant created_at) {
        this.createdAt = created_at;
    }
}
