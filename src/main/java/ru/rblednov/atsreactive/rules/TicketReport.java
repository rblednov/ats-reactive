package ru.rblednov.atsreactive.rules;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode
public class TicketReport {
    private boolean isOk = true;
    private int level;
    private String reason;
    private UUID deliveryId;
    private OffsetDateTime createTime;

    public boolean isBad() {
        return !isOk;
    }
}
