package multiwarehouse.common.domain.event;

public class EmptyEvent implements DomainEvent<Void> {
    public static final EmptyEvent INSTANCE = new EmptyEvent();

    private EmptyEvent() {
    }

    @Override
    public void fire() {
        // Empty implementation as this is an empty event
    }
}
