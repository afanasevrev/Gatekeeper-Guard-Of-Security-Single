package com.alrosa.staa.gatekeeper_server_single.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebSocketClientController {
    @Autowired
    private AmqpTemplate amqpTemplate;
}
