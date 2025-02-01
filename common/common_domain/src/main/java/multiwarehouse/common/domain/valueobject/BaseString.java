package multiwarehouse.common.domain.valueobject;

import java.util.Objects;

public abstract class BaseString<T> {
    private final T value;

    protected BaseString(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseString<?> baseString = (BaseString<?>) o;
        return Objects.equals(value, baseString.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
