package multiwarehouse.common.domain.valueobject;

import java.util.UUID;

public class Address {
    private final UUID id;

    private final String street;

    private final String city;

    private final int postalCode;

    public Address(UUID id, String street, String city, int postalCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }   

    public int getPostalCode() {
        return postalCode;
    }
}
