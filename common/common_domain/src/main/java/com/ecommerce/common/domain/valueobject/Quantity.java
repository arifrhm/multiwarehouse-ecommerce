package multiwarehouse.common.domain.valueobject;

public class Quantity {
    private final int value;

    public Quantity(int value) {
        this.value = value;
    }   

    public Quantity add(Quantity quantity) {
        return new Quantity(this.value + quantity.value);
    }

    public Quantity substract(Quantity quantity) {
        return new Quantity(this.value - quantity.value);
    }

    public int getValue() {
        return value;
    }
}
