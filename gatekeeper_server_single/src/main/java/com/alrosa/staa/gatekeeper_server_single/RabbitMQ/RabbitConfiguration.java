package com.alrosa.staa.gatekeeper_server_single.RabbitMQ;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
public class RabbitConfiguration {
    private Logger logger = Logger.getLogger(RabbitConfiguration.class);
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("admin");
        cachingConnectionFactory.setPassword("admin");
        return cachingConnectionFactory;
    }
    @Bean
    public AmqpAdmin amqpAdmin() {
        AmqpAdmin amqpAdmin = new RabbitAdmin(connectionFactory());
        return amqpAdmin;
    }
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setReplyTimeout(60 * 1000);
        return rabbitTemplate;
    }
    @Bean
    public Queue queueForOperator() {
        return new Queue("Server");
    }
}
