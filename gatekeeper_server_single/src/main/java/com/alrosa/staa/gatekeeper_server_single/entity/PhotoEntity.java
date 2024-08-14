package com.alrosa.staa.gatekeeper_server_single.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "photos")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Lob
    @Column(name = "user_photo", columnDefinition = "LONGBLOB")
    private byte[] userPhoto;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    public PhotoEntity() {}
    public PhotoEntity(Long id, byte[] userPhoto, UserEntity userEntity) {
        this.id = id;
        this.userPhoto = userPhoto;
        this.userEntity = userEntity;
    }
}
