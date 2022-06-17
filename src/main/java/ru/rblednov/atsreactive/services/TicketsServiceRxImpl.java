package ru.rblednov.atsreactive.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.dto.TicketsDTO;
import ru.rblednov.atsreactive.rules.TicketReport;
import ru.rblednov.atsreactive.services.tickets.TicketsService;

import java.util.List;


@Service
public class TicketsServiceRxImpl implements TicketsService {

    @Override
    public void performReport(TicketReport report) {

    }

    @Override
    public Mono<List<TicketsDTO>> getTickets(Mono<Integer> page, Mono<Integer> size) {
        return null;
    }
}
