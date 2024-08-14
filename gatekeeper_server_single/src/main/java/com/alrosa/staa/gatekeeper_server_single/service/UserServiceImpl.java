package com.alrosa.staa.gatekeeper_server_single.service;

import com.alrosa.staa.gatekeeper_server_single.entity.UserEntity;
import com.alrosa.staa.gatekeeper_server_single.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public String createUser(UserEntity entity) {
        userRepository.save(entity);
        return "Пользователь добавлен в БД";
    }
    @Override
    public List<UserEntity> readUsers() {
        return userRepository.findAll();
    }
    @Override
    public UserEntity readUser(Long id) {
        return userRepository.findById(id).get();
    }
    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "Пользователь удален из БД";
    }
    @Override
    public String updateUser(UserEntity entity, Long id) {
        UserEntity user = userRepository.findById(id).get();
        user.setFirstName(entity.getFirstName());
        user.setMiddleName(entity.getMiddleName());
        user.setLastName(entity.getLastName());
        user.setCompany(entity.getCompany());
        user.setCardId(entity.getCardId());
        userRepository.save(user);
        return "Пользователь успешно обновлён";
    }
}
