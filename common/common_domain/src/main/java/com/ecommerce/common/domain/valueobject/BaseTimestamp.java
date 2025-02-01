package multiwarehouse.common.domain.valueobject;

import java.util.Objects;

public abstract class BaseTimestamp<T> {
    private final T value;

    protected BaseTimestamp(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseTimestamp<?> that = (BaseTimestamp<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
