package ru.rblednov.atsreactive.dto;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TicketDTO {
    private UUID id;
    private Integer level;
    private UUID deliveryId;
    private String explanation;
    private OffsetDateTime createTime;
}
