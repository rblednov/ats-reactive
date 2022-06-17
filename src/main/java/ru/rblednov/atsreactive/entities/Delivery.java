package ru.rblednov.atsreactive.entities;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Delivery implements Serializable {
    @Serial
    private static final long serialVersionUID = -8958517719978702484L;

    private UUID id;

    private CustomerType customerType;

    private Status status;

    private OffsetDateTime expectedTime;

    private Integer distance;

    private Integer riderRating;

    private Integer foodTime;

    private Integer rideTime;

    public enum Status {
        received, preparing, pickedup, delivered
    }

    public enum CustomerType {
        NEW, VIP, LOYAL
    }
}
