package com.alrosa.staa.gatekeeper_server_single.repository;

import com.alrosa.staa.gatekeeper_server_single.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<UserEntity, Long> {}
