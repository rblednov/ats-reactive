package ru.rblednov.atsreactive.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.services.deliveries.DeliveriesChecker;
import ru.rblednov.atsreactive.services.deliveries.store.DeliveriesStoreService;
import ru.rblednov.atsreactive.services.tickets.TicketsService;

import java.util.Optional;

@Service
public class TicketsRefreser {
    private final DeliveriesStoreService deliveriesStoreService;
    private final DeliveriesChecker deliveriesChecker;
    private final TicketsService ticketsService;


    public TicketsRefreser(DeliveriesStoreService deliveriesStoreService,
                           DeliveriesChecker deliveriesChecker,
                           TicketsService ticketsService) {
        this.deliveriesStoreService = deliveriesStoreService;
        this.deliveriesChecker = deliveriesChecker;
        this.ticketsService = ticketsService;
    }

    public Mono<Void> refresh() {
        return deliveriesStoreService
                .getAllSuspectDeliveries()
                .flatMapMany(Flux::fromIterable)
                .map(deliveriesChecker::checkDelivery)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .flatMap(ticketsService::performReport)
                .then();
    }
}
