package multiwarehouse.order_service.valueobject;

import java.math.BigDecimal;

public class OrderTotal {
    private final BigDecimal value;

    public OrderTotal(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Total cannot be negative");
        }
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderTotal)) return false;
        OrderTotal that = (OrderTotal) o;
        return value.compareTo(that.value) == 0;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
