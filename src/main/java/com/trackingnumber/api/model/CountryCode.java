package com.trackingnumber.api.model;

import lombok.Data;

@Data
public class CountryCode {
    private String countryCode;
    private String countryName;

    public CountryCode(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
