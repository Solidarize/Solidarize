package com.solidarize.messaging;

import com.solidarize.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FetchMailSubscriber {

    private static final String NO_ROUTING_KEY = "";
    private UserService userService;
    private RabbitTemplate rabbitTemplate;
    private String mailExchange;

    @Autowired
    public FetchMailSubscriber(UserService userService, RabbitTemplate rabbitTemplate,
                               @Value("${rabbitmq.mail.exchange}") String mailExchange) {
        this.userService = userService;
        this.rabbitTemplate = rabbitTemplate;
        this.mailExchange = mailExchange;
    }

    @RabbitListener(queues = "#{@fetchMailQueue}")
    public void fetchMailListener(@Payload FetchNotificationMailDTO dto) {
        if (dto.isToFetchMail.equals("true")) {
            userService.allUsers().forEach(user ->
                    rabbitTemplate.convertAndSend(mailExchange, NO_ROUTING_KEY, new FetchMailDTO(user.getMail()))
            );
        }
    }

    static class FetchNotificationMailDTO {
        private String isToFetchMail;

        public String getIsToFetchMail() {
            return isToFetchMail;
        }

        public void setIsToFetchMail(String isToFetchMail) {
            this.isToFetchMail = isToFetchMail;
        }
    }

    static class FetchMailDTO {
        private String mail;

        public FetchMailDTO(String mail) {
            this.mail = mail;
        }

        public String getMail() {
            return mail;
        }
    }
}
