package ru.rblednov.atsreactive.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.rblednov.atsreactive.entities.Delivery;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
public class DeliveryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2581102217692413497L;

    private UUID id;

    private Delivery.CustomerType customerType;

    private Delivery.Status status;

    private OffsetDateTime expectedTime;

    private Integer distance;

    private Integer riderRating;

    private Integer foodTime;

    private Integer rideTime;
}
