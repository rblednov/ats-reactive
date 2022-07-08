package ru.rblednov.atsreactive.services.deliveries.store;

import ru.rblednov.atsreactive.dto.DeliveryDTO;

import java.util.Set;

public interface DeliveriesStoreService {
    Set<DeliveryDTO> getAllSuspectDeliveries();
}
