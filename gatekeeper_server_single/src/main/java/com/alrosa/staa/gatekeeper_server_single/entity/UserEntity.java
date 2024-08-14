package com.alrosa.staa.gatekeeper_server_single.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "company")
    private String company;
    @Column(name = "card_id")
    private String cardId;
    public UserEntity() {}
    public UserEntity(Long id, String firstName, String secondName, String lastName, String company, String cardId) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.company = company;
        this.cardId = cardId;
    }
}
