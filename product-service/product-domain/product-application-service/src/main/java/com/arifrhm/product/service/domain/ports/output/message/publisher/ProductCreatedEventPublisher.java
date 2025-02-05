
package com.arifrhm.product.service.domain.ports.output.message.publisher;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.product.service.domain.event.ProductCreatedEvent;

public interface ProductCreatedEventPublisher extends DomainEventPublisher<ProductCreatedEvent> {
}
