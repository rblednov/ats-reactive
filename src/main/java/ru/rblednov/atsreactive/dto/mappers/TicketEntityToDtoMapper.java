package ru.rblednov.atsreactive.dto.mappers;

import lombok.ToString;
import ru.rblednov.atsreactive.dto.TicketDTO;
import ru.rblednov.atsreactive.entities.Ticket;

@ToString
public class TicketEntityToDtoMapper {
    public static TicketDTO map(Ticket ticket) {
        return TicketDTO.builder()
                .id(ticket.getId())
                .level(ticket.getLevel())
                .deliveryId(ticket.getDeliveryId())
                .explanation(ticket.getReason())
                .createTime(ticket.getCreateTime())
                .build();
    }
}
