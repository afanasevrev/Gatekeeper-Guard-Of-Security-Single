package com.alrosa.staa.gatekeeper_client_single.data;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserFullName {
    private Long id;
    private String fullName;
    public UserFullName() {}
    public UserFullName(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
