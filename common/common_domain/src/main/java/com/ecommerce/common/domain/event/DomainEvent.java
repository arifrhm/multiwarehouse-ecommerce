package multiwarehouse.common.domain.event;

public interface DomainEvent<T> {
    void fire();
}
