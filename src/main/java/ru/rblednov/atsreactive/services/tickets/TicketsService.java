package ru.rblednov.atsreactive.services.tickets;

import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.dto.TicketDTO;
import ru.rblednov.atsreactive.rules.TicketReport;

import java.util.List;

public interface TicketsService {
    Mono<Void> performReport(TicketReport report);

    Mono<List<TicketDTO>> getTickets(Integer page, Integer size);
}
