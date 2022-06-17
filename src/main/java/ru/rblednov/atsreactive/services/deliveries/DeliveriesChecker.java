package ru.rblednov.atsreactive.services.deliveries;

import ru.rblednov.ats.dto.DeliveryDTO;
import ru.rblednov.ats.rules.TicketReport;

import java.util.Optional;

public interface DeliveriesChecker {
    Optional<TicketReport> checkDelivery(DeliveryDTO deliveryDTO);
}
