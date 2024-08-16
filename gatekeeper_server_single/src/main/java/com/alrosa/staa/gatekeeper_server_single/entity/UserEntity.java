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
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "company")
    private String company;
    @Column(name = "card_id")
    private String cardId;
    public UserEntity() {}
    public UserEntity(String firstName, String middleName, String lastName, String company, String cardId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.company = company;
        this.cardId = cardId;
    }
    @Override
    public String toString() {
        return this.firstName + " " + this.middleName + " " + this.lastName;
    }
}
