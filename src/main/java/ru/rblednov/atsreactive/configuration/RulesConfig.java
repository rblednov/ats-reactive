package ru.rblednov.atsreactive.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class RulesConfig {
    @Value("${app.rules.vip-increment}")
    private Integer vipIncrement;
}
