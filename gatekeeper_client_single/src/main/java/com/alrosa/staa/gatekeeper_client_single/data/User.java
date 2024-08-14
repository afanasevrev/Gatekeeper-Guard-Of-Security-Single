package com.alrosa.staa.gatekeeper_client_single.data;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class User {
    private Long id;
    private String fullName;
    public User() {}
    public User(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
