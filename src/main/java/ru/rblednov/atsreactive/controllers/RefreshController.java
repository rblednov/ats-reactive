package ru.rblednov.atsreactive.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.services.TicketsRefreser;

@Slf4j
@ResponseBody
@Controller
public class RefreshController {
    private final TicketsRefreser ticketsRefresher;

    public RefreshController(TicketsRefreser ticketsRefresher) {
        this.ticketsRefresher = ticketsRefresher;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/internal/refresh")
    public Mono<String> refreshTickets() {


        return Mono.fromRunnable(() -> log.info("Received request to refresh tickets."))
                .then(ticketsRefresher.refresh())
                .map(v -> "tickets refreshed");
    }
}
