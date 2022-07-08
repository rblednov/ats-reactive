package ru.rblednov.atsreactive.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(schema = "tickets", name = "tickets")
public class Ticket {
    @Id
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