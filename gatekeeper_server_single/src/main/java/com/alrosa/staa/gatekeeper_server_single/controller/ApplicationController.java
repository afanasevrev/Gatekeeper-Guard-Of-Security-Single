package com.alrosa.staa.gatekeeper_server_single.controller;

import com.alrosa.staa.gatekeeper_server_single.entity.UserEntity;
import com.alrosa.staa.gatekeeper_server_single.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    private String getInfo() {
        return "Система контроля и управления доступом. Версия для работы с одним контроллером";
    }
    @GetMapping("/getUsers")
    private List<UserEntity> getUsers() {
        return userService.readUsers();
    }
    @GetMapping("/getUser/{id}")
    private UserEntity getUser(@PathVariable String id) {
        return userService.readUser(Long.parseLong(id));
    } 
}
