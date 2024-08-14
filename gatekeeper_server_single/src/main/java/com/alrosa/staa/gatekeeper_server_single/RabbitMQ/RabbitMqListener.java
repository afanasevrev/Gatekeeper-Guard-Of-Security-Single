package com.alrosa.staa.gatekeeper_server_single.RabbitMQ;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@EnableRabbit
@Component
public class RabbitMqListener {
    private Logger logger = Logger.getLogger(RabbitMqListener.class);
    private Gson gson = new Gson();
    @Autowired
    private AmqpTemplate template;
    @RabbitListener(queues = "Server")
    private void Queue(String message) {
        logger.info(message);
    }
}
