package ru.rblednov.atsreactive.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.dto.TicketDTO;
import ru.rblednov.atsreactive.dto.mappers.TicketEntityToDtoMapper;
import ru.rblednov.atsreactive.rules.TicketReport;
import ru.rblednov.atsreactive.services.tickets.TicketsService;
import ru.rblednov.atsreactive.services.tickets.store.TicketsStoreService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TicketsServiceRxImpl implements TicketsService {

    private final TicketsStoreService ticketsStoreService;

    public TicketsServiceRxImpl(TicketsStoreService ticketsStoreService) {
        this.ticketsStoreService = ticketsStoreService;
    }


    @Override
    public void performReport(TicketReport report) {

    }

    @Override
    public Mono<List<TicketDTO>> getTickets(Integer page, Integer size) {
        return ticketsStoreService.getOpenedTickets(page, size)
                .map(tickets ->
                        tickets.stream()
                                .map(TicketEntityToDtoMapper::map)
                                .collect(Collectors.toList())
                )
                .doOnNext(Object::toString);
    }
}
