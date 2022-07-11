package ru.rblednov.atsreactive.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.dto.TicketDTO;
import ru.rblednov.atsreactive.dto.mappers.TicketEntityToDtoMapper;
import ru.rblednov.atsreactive.entities.Ticket;
import ru.rblednov.atsreactive.services.tickets.store.TicketsStoreServiceRxImpl;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({TicketsServiceRxImpl.class})
public class TicketsServiceRxImplTest {
    private static final int page = 0;
    private static final int size = 10;


    @Autowired
    private TicketsServiceRxImpl ticketsServiceRx;
    @MockBean
    private TicketsStoreServiceRxImpl ticketsStoreServiceRx;

    @Test
    public void getTicketsTest() {
        Ticket ticket1 = new Ticket(
                UUID.randomUUID(),
                UUID.randomUUID(),
                Ticket.Status.OPEN,
                5,
                "text",
                OffsetDateTime.now());
        TicketDTO ticketDTO1 = TicketEntityToDtoMapper.map(ticket1);

        Ticket ticket2 = new Ticket(
                UUID.randomUUID(),
                UUID.randomUUID(),
                Ticket.Status.OPEN,
                4,
                "text",
                OffsetDateTime.now());
        TicketDTO ticketDTO2 = TicketEntityToDtoMapper.map(ticket2);

        when(ticketsStoreServiceRx.getOpenedTickets(any(), any()))
                .thenReturn(Mono.just(List.of(ticket1, ticket2)));
        List<TicketDTO> actualList = ticketsServiceRx.getTickets(page, size).block();
        assertEquals(ticketDTO1, actualList.get(0));
        assertEquals(ticketDTO2, actualList.get(1));
    }
}
