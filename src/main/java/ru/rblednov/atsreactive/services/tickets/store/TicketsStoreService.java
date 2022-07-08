package ru.rblednov.atsreactive.services.tickets.store;

import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.entities.Ticket;
import ru.rblednov.atsreactive.rules.TicketReport;

import java.util.List;

public interface TicketsStoreService {
    void trySaveOrUpdateLevelAndExplanation(TicketReport report);

    Mono<List<Ticket>> getOpenedTickets(Integer page, Integer size);
}
