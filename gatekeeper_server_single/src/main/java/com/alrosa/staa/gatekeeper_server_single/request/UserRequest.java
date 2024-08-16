package com.alrosa.staa.gatekeeper_server_single.request;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserRequest {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String company;
    private String cardId;
    private String status;
    private byte[] userPhoto;
    public UserRequest() {}
    public UserRequest(String status) {
        this.status = status;
    }
    public UserRequest(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}
