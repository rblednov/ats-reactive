package ru.rblednov.atsreactive.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.rblednov.atsreactive.entities.Delivery;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeliveriesRepository extends PagingAndSortingRepository<Delivery, UUID> {
    List<Delivery> findAllByStatusIsNot(Delivery.Status status);
}
