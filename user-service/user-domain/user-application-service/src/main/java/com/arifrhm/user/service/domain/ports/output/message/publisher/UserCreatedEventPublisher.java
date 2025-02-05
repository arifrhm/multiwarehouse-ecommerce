
package com.arifrhm.user.service.domain.ports.output.message.publisher;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.user.service.domain.event.UserCreatedEvent;

public interface UserCreatedEventPublisher extends DomainEventPublisher<UserCreatedEvent> {
}
