package multiwarehouse.order_service.valueobject;

import java.util.Objects;

public class ShippingAddress {
    private final String recipientName;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String postalCode;
    private final String country;

    public ShippingAddress(String recipientName, String streetAddress, String city, String state, String postalCode, String country) {
        this.recipientName = recipientName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShippingAddress)) return false;
        ShippingAddress that = (ShippingAddress) o;
        return recipientName.equals(that.recipientName) &&
                streetAddress.equals(that.streetAddress) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                postalCode.equals(that.postalCode) &&
                country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipientName, streetAddress, city, state, postalCode, country);
    }
}
