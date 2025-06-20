package com.trackingnumber.api.entity;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;


@Getter
@Data
@Setter
@Document(collection = "tracking_requests")
public class TrackingNumberRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String requestId;
    @Size(min = 2, max = 2, message = "Origin country code must be 2 letters (ISO Alpha-2)")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Origin country code must be uppercase ISO Alpha-2")
    private String originCountryId;

    @Size(min = 2, max = 2, message = "Origin country code must be 2 letters (ISO Alpha-2)")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Origin country code must be uppercase ISO Alpha-2")
    private String destinationCountryId;

    @DecimalMin(value = "0.001", message = "Please enter the order’s weight in kilograms, up to three decimal places")
    @Digits(integer = 5, fraction = 3)
    private BigDecimal weight;

    private Instant createdAt;

    @NotNull
    private String createdBy;

    @NotNull
    @Pattern(
            regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$",
            message = "Please enter a valid UUID")
    private String customerId;

    @NotNull
    @NotBlank
    @Size(min = 3, message = "Please enter a valid customer name at least 3 letters long.")
    private String customerName;

    @NotNull
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "The customer’s name in slug-case/kebab-case (e.g. redbox-logistics)")
    private String customerSlug;

    public TrackingNumberRequest() {
    }
    public String getOriginCountryId() {
        return originCountryId;
    }

    public void setOriginCountryId(String originCountryId) {
        this.originCountryId = originCountryId;
    }

    public String getDestinationCountryId() {
        return destinationCountryId;
    }

    public void setDestinationCountryId(String destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Instant  getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSlug() {
        return customerSlug;
    }

    public void setCustomerSlug(String customerSlug) {
        this.customerSlug = customerSlug;
    }
}
