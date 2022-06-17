package ru.rblednov.atsreactive.rules;

import org.springframework.stereotype.Component;
import ru.rblednov.ats.configuration.RulesConfig;
import ru.rblednov.ats.dto.DeliveryDTO;
import ru.rblednov.ats.entities.Delivery;

import java.time.OffsetDateTime;

@Component
public class DeliveryLateRule implements TicketRiseRule {
    public final static int baseLevel = 5;
    public final static String explanation = "Delivery time run out.";

    private final RulesConfig rulesConfig;

    public DeliveryLateRule(RulesConfig rulesConfig) {
        this.rulesConfig = rulesConfig;
    }

    @Override
    public TicketReport checkDelivery(DeliveryDTO delivery) {
        TicketReport ticketReport = new TicketReport();
        if (delivery.getExpectedTime().isBefore(OffsetDateTime.now())) {
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
