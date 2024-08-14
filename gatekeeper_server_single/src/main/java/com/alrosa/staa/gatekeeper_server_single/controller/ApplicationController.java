package com.alrosa.staa.gatekeeper_server_single.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ApplicationController {
    @GetMapping("/")
    private String getInfo() {
        return "Система контроля и управления доступом. Версия для работы с одним контроллером";
    }
}
