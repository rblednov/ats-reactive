package ru.rblednov.atsreactive.rules;

import org.springframework.stereotype.Component;
import ru.rblednov.ats.configuration.RulesConfig;
import ru.rblednov.ats.dto.DeliveryDTO;
import ru.rblednov.ats.entities.Delivery;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class ReceivedLateRule implements TicketRiseRule {
    public final static int baseLevel = 3;
    public final static int maxTimeToTakeOrder = 7;

    public final static String explanation = "Delivery at status received for a long time.";

    private final RulesConfig rulesConfig;

    public ReceivedLateRule(RulesConfig rulesConfig) {
        this.rulesConfig = rulesConfig;
    }

    @Override
    public TicketReport checkDelivery(DeliveryDTO delivery) {
        TicketReport ticketReport = new TicketReport();
        if (delivery.getExpectedTime()
                .minus(delivery.getRideTime(), ChronoUnit.MINUTES)
                .minus(delivery.getFoodTime(), ChronoUnit.MINUTES)
                .plus(maxTimeToTakeOrder, ChronoUnit.MINUTES)
                .isBefore(OffsetDateTime.now())
                && delivery.getStatus().equals(Delivery.Status.received)) {
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
