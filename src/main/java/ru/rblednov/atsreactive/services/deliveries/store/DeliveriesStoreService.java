package ru.rblednov.atsreactive.services.deliveries.store;

import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.dto.DeliveryDTO;

import java.util.Set;

public interface DeliveriesStoreService {
    Mono<Set<DeliveryDTO>> getAllSuspectDeliveries();
}
