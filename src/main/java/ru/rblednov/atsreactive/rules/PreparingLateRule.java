package ru.rblednov.atsreactive.rules;

import org.springframework.stereotype.Service;
import ru.rblednov.atsreactive.configuration.RulesConfig;
import ru.rblednov.atsreactive.dto.DeliveryDTO;
import ru.rblednov.atsreactive.entities.Delivery;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class PreparingLateRule implements TicketRiseRule {
    public final static int baseLevel = 4;

    public final static String explanation = "Food preparing time run out.";

    private final RulesConfig rulesConfig;

    public PreparingLateRule(RulesConfig rulesConfig) {
        this.rulesConfig = rulesConfig;
    }

    @Override
    public TicketReport checkDelivery(DeliveryDTO delivery) {
        TicketReport ticketReport = new TicketReport();
        if (delivery.getExpectedTime().minus(delivery.getRideTime(), ChronoUnit.MINUTES)
                .isBefore(OffsetDateTime.now()) && delivery.getStatus().equals(Delivery.Status.preparing)) {
            ticketReport.setOk(false);
            ticketReport.setLevel(baseLevel);
        }

        if (delivery.getCustomerType().equals(Delivery.CustomerType.VIP) && ticketReport.isBad()) {
            ticketReport.setLevel(ticketReport.getLevel() + rulesConfig.getVipIncrement());
        }

        if (ticketReport.isBad()) {
            ticketReport.setDeliveryId(delivery.getId());
            ticketReport.setReason(explanation);
            ticketReport.setCreateTime(OffsetDateTime.now());
        }

        return ticketReport;
    }
}
