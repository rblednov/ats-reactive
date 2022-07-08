package ru.rblednov.atsreactive.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import ru.rblednov.atsreactive.dto.TicketDTO;
import ru.rblednov.atsreactive.dto.mappers.TicketEntityToDtoMapper;
import ru.rblednov.atsreactive.entities.Ticket;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Import({TicketsServiceRxImpl.class})
public class TicketsServiceRxImplTest {
    private static final int page = 0;
    private static final int size = 10;


    @Autowired
    private TicketsServiceRxImpl ticketsServiceRx;

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

        List<TicketDTO> actualList = ticketsServiceRx.getTickets(page, size).block();
        assertEquals(ticket1, actualList.get(0));
        assertEquals(ticket2, actualList.get(1));
    }
}
