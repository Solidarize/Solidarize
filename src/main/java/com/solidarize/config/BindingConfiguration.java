package com.solidarize.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
public class BindingConfiguration {

    @Bean
    @Qualifier("fetchMailBinding")
    public Binding fetchMailBinding(
            @Qualifier("fetchMailQueue") Queue fetchMailQueue,
            @Qualifier("fetchMailExchange")
                    FanoutExchange fetchMailExchange) {
        return bind(fetchMailQueue).to(fetchMailExchange);
    }
}
