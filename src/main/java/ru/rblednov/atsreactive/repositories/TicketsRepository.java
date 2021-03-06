package ru.rblednov.atsreactive.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.rblednov.atsreactive.entities.Ticket;

import java.util.List;
import java.util.UUID;

@Repository
public interface TicketsRepository extends PagingAndSortingRepository<Ticket, UUID> {
    Ticket getTicketsByDeliveryIdAndStatusIs(UUID deliveryId, Ticket.Status status);
    List<Ticket> findAllByStatusIsOrderByLevelDesc(Ticket.Status status, Pageable page);
}
