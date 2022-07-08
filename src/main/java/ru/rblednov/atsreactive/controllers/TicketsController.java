package ru.rblednov.atsreactive.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.dto.TicketsResponseDTO;
import ru.rblednov.atsreactive.services.TicketsServiceRxImpl;

@RestController
public class TicketsController {
    private TicketsServiceRxImpl ticketsService;

    @GetMapping("/tickets")
    public Mono<TicketsResponseDTO> getTickets(@RequestParam(value = "page", defaultValue = "0") Mono<Integer> page,
                                               @RequestParam(value = "size", defaultValue = "5") Mono<Integer> size) {
        return Mono.zip(page, size)
                .flatMap(t -> ticketsService.getTickets(t.getT1(), t.getT2())
                        .map(ticketDTOS -> new TicketsResponseDTO(ticketDTOS, t.getT1(), t.getT2()))
                );
    }
}
