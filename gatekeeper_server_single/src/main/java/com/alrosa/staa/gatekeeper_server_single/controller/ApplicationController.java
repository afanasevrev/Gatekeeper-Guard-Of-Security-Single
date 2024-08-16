package com.alrosa.staa.gatekeeper_server_single.controller;

import com.alrosa.staa.gatekeeper_server_single.entity.PhotoEntity;
import com.alrosa.staa.gatekeeper_server_single.entity.UserEntity;
import com.alrosa.staa.gatekeeper_server_single.request.UserFullName;
import com.alrosa.staa.gatekeeper_server_single.request.UserRequest;
import com.alrosa.staa.gatekeeper_server_single.service.PhotoService;
import com.alrosa.staa.gatekeeper_server_single.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
public class ApplicationController {
    private final Logger logger = Logger.getLogger(ApplicationController.class);
    private Long id;
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;
    @GetMapping("/")
    private String getInfo() {
        return "Система контроля и управления доступом. Версия для работы с одним контроллером";
    }
    @GetMapping("/getUsers")
    private List<UserFullName> getUsers() {
        List<UserEntity> userEntities = userService.readUsers();
        List<UserFullName> userFullNames = new ArrayList<UserFullName>();
        for (UserEntity userEntity: userEntities) {
            userFullNames.add(new UserFullName(userEntity.getId(), userEntity.toString()));
        }
        return userFullNames;
    }
    @GetMapping("/getUser/{id}")
    private UserEntity getUser(@PathVariable String id) {
        return userService.readUser(Long.parseLong(id));
    }
    @PostMapping("/setUser")
    private UserRequest setUser(@RequestBody UserRequest userRequest) {
        UserEntity userEntity = new UserEntity(userRequest.getFirstName(), userRequest.getMiddleName(), userRequest.getLastName(), userRequest.getCompany(), userRequest.getCardId());
        userService.createUser(userEntity);
        if (userRequest.getUserPhoto() != null) {
            PhotoEntity photoEntity = new PhotoEntity(userRequest.getUserPhoto(), userEntity);
            photoService.createPhoto(photoEntity);
        }
        return new UserRequest("Пользователь успешно добавлен в систему");
    }
}
