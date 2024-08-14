package com.alrosa.staa.gatekeeper_server_single.service;

import com.alrosa.staa.gatekeeper_server_single.entity.UserEntity;
import java.util.List;
public interface UserService {
    String createUser(UserEntity entity);
    List<UserEntity> readUsers();
    UserEntity readUser(Long id);
    String deleteUser(Long id);
    String updateUser(UserEntity entity, Long id);
}
