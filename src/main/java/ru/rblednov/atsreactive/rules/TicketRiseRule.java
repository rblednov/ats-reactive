package ru.rblednov.atsreactive.rules;

import ru.rblednov.atsreactive.dto.DeliveryDTO;

public interface TicketRiseRule {
    TicketReport checkDelivery(DeliveryDTO delivery);
}
