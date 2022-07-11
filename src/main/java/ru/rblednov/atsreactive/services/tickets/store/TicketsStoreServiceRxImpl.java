package ru.rblednov.atsreactive.services.tickets.store;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.rblednov.atsreactive.entities.Ticket;
import ru.rblednov.atsreactive.repositories.TicketsRepository;
import ru.rblednov.atsreactive.rules.TicketReport;

import java.util.List;

@Slf4j
@Service
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

        /*how to do it in a more common way?*/
        return Mono.just("")
                /*async logging?*/
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(t -> log.info("going to getOpenedTickets"))
                .map(empty -> ticketsRepository.findAllByStatusIsOrderByLevelDesc(Ticket.Status.OPEN, PageRequest.of(page, size)));
    }
}
