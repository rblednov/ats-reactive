package ru.rblednov.atsreactive.entities;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Ticket {

    private UUID id;

    private UUID deliveryId;

    private Status status;

    private Integer level;

    private String reason;

    private OffsetDateTime createTime;

    public enum Status {
        OPEN,
        WIP,
        CLOSE
    }
}
