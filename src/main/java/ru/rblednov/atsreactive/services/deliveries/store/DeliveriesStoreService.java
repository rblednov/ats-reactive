package ru.rblednov.atsreactive.services.deliveries.store;

import ru.rblednov.ats.dto.DeliveryDTO;

import java.util.Set;

public interface DeliveriesStoreService {
    Set<DeliveryDTO> getAllSuspectDeliveries();
}
