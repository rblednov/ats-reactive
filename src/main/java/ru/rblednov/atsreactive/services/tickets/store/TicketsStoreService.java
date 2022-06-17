package ru.rblednov.atsreactive.services.tickets.store;

import ru.rblednov.atsreactive.entities.Ticket;
import ru.rblednov.atsreactive.rules.TicketReport;

import java.util.List;

public interface TicketsStoreService {
    void trySaveOrUpdateLevelAndExplanation(TicketReport report);

    List<Ticket> getOpenedTickets(Integer page, Integer size);
}
