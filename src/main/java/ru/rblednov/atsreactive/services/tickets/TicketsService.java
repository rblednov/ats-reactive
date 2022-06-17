package ru.rblednov.atsreactive.services.tickets;

import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.dto.TicketsDTO;
import ru.rblednov.atsreactive.rules.TicketReport;

import java.util.List;

public interface TicketsService {
    void performReport(TicketReport report);

    Mono<List<TicketsDTO>> getTickets(Mono<Integer> page, Mono<Integer> size);
}
