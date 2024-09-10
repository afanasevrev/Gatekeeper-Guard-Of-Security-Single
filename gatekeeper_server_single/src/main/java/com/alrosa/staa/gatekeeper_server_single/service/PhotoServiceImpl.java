package com.alrosa.staa.gatekeeper_server_single.service;

import com.alrosa.staa.gatekeeper_server_single.entity.PhotoEntity;
import com.alrosa.staa.gatekeeper_server_single.entity.UserEntity;
import com.alrosa.staa.gatekeeper_server_single.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public String createPhoto(PhotoEntity entity) {
        photoRepository.save(entity);
        return "Фотография пользователя добавлена";
    }
    @Override
    public List<PhotoEntity> readPhotos() {
        return photoRepository.findAll();
    }
    @Override
    public PhotoEntity readPhoto(Long id) {
        return photoRepository.findById(id).get();
    }
    @Override
    public String deletePhoto(Long id) {
        photoRepository.deleteById(id);
        return "Фотография удалена";
    }
    @Override
    public String updatePhoto(PhotoEntity entity, Long id) {
        PhotoEntity photoEntity = photoRepository.findById(id).get();
        photoEntity.setUserPhoto(entity.getUserPhoto());
        photoRepository.save(photoEntity);
        return "Фотография пользователя успешно обновлена в БД";
    }
    @Override
    public PhotoEntity findByUserEntity(UserEntity userEntity) {
        return photoRepository.findByUserEntity(userEntity);
    }
}
