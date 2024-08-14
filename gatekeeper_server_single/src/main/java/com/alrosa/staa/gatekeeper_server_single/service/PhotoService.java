package com.alrosa.staa.gatekeeper_server_single.service;

import com.alrosa.staa.gatekeeper_server_single.entity.PhotoEntity;
import com.alrosa.staa.gatekeeper_server_single.entity.UserEntity;
import java.util.List;
public interface PhotoService {
    String createPhoto(PhotoEntity entity);
    List<PhotoEntity> readPhotos();
    PhotoEntity readPhoto(Long id);
    String deletePhoto(Long id);
    String updatePhoto(PhotoEntity entity, Long id);
    PhotoEntity findByUserEntity(UserEntity userEntity);
}
