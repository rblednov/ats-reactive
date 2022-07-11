package ru.rblednov.atsreactive.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.dto.TicketsResponseDTO;
import ru.rblednov.atsreactive.services.TicketsServiceRxImpl;

@Slf4j
@RestController
public class TicketsController {
    private final TicketsServiceRxImpl ticketsService;

    public TicketsController(TicketsServiceRxImpl ticketsService) {
        this.ticketsService = ticketsService;
    }

    @GetMapping("/tickets")
    public Mono<TicketsResponseDTO> getTickets(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                               @RequestParam(value = "size", defaultValue = "5") Integer size) {
        log.info("Received request to get tickets.");
        return ticketsService.getTickets(page, size).map(ticketDTOS -> new TicketsResponseDTO(ticketDTOS, page, size));
    }
}
