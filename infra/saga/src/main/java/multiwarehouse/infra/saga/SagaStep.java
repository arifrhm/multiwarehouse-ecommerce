package multiwarehouse.infra.saga;

public interface SagaStep<T> {
    T process(T data);
    T rollback(T data);
}
