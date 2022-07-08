package ru.rblednov.atsreactive.services.tickets.store;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.rblednov.atsreactive.entities.Ticket;
import ru.rblednov.atsreactive.repositories.TicketsRepository;
import ru.rblednov.atsreactive.rules.TicketReport;

import java.util.List;

@Slf4j
public class TicketsStoreServiceRxImpl implements TicketsStoreService {

    private final TicketsRepository ticketsRepository;

    public TicketsStoreServiceRxImpl(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }


    @Override
    public void trySaveOrUpdateLevelAndExplanation(TicketReport report) {

    }

    @Override
    public Mono<List<Ticket>> getOpenedTickets(Integer page, Integer size) {
        /*try out how this will work also test with thread sleep*/
        return Mono.empty()
                /*async logging?*/
                .doOnNext(t->log.info("going to getOpenedTickets"))
                .publishOn(Schedulers.boundedElastic())
                .map(empty ->
                        ticketsRepository.findAllByStatusIsOrderByLevelDesc(Ticket.Status.OPEN, PageRequest.of(page, size)));
    }
}
