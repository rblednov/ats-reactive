package ru.rblednov.atsreactive.dto.mappers;

import ru.rblednov.atsreactive.dto.DeliveryDTO;
import ru.rblednov.atsreactive.entities.Delivery;

public class DeliveryEntityToDtoMapper {
    public static DeliveryDTO map(Delivery delivery) {
        return DeliveryDTO.builder()
                .id(delivery.getId())
                .customerType(delivery.getCustomerType())
                .status(delivery.getStatus())
                .expectedTime(delivery.getExpectedTime())
                .distance(delivery.getDistance())
                .riderRating(delivery.getRiderRating())
                .foodTime(delivery.getFoodTime())
                .rideTime(delivery.getRideTime())
                .build();
    }
}
