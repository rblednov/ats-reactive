package ru.rblednov.atsreactive.dto.mappers;

import ru.rblednov.ats.dto.TicketsDTO;
import ru.rblednov.ats.entities.Ticket;

public class TicketEntityToDtoMapper {
    public static TicketsDTO map(Ticket ticket) {
        return TicketsDTO.builder()
                .id(ticket.getId())
                .level(ticket.getLevel())
                .deliveryId(ticket.getDeliveryId())
                .explanation(ticket.getReason())
                .createTime(ticket.getCreateTime())
                .build();
    }
}
