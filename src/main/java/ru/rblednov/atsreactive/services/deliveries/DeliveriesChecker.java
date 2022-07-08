package ru.rblednov.atsreactive.services.deliveries;

import ru.rblednov.atsreactive.dto.DeliveryDTO;
import ru.rblednov.atsreactive.rules.TicketReport;

import java.util.Optional;

public interface DeliveriesChecker {
    Optional<TicketReport> checkDelivery(DeliveryDTO deliveryDTO);
}
