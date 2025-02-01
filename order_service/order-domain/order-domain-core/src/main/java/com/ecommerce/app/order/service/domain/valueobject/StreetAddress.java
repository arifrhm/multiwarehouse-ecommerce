package multiwarehouse.ecommerce.order.service.domain.valueobject;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StreetAddress {
    private final String street;
    private final String city;
    private final String state;
    private final String country;
    private final String postalCode;

    public StreetAddress(String street, String city, String state, String country, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetAddress that = (StreetAddress) o;
        return street.equals(that.street) && city.equals(that.city) && state.equals(that.state) && country.equals(that.country) && postalCode.equals(that.postalCode);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(street, city, state, country, postalCode);
    }
}
