package com.arifrhm.warehouse.service.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class StreetAddress {

    private final UUID id;

    private String street;

    private String postalCode;

    private String city;

    private double latitude;

    private double longitude;

    public StreetAddress(UUID id, String street, String postalCode, String city, double latitude, double longitude) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public boolean isValid() {
        return street != null && !street.trim().isEmpty() &&
                postalCode != null && !postalCode.trim().isEmpty() &&
                city != null && !city.trim().isEmpty();
    }


    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }


    public double getLatitude() {
        return latitude;
    }


    public double getLongitude() {
        return longitude;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetAddress that = (StreetAddress) o;
        return Double.compare(latitude, that.latitude) == 0 && Double.compare(longitude, that.longitude) == 0 && Objects.equals(id, that.id) && Objects.equals(street, that.street) && Objects.equals(postalCode, that.postalCode) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, postalCode, city, latitude, longitude);
    }
}
