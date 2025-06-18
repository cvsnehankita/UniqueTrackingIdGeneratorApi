package com.trackingnumber.api.entity;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;


@Getter
@Data
@Setter
@Document(collection = "tracking_requests")
public class TrackingNumberRequest {
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
}
