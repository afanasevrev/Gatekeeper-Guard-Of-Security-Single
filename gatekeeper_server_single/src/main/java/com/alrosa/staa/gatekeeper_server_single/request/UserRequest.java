package com.alrosa.staa.gatekeeper_server_single.request;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserRequest {
    private Long id;
    private String status;
    public UserRequest() {}
    public UserRequest(String status) {
        this.status = status;
    }
    public UserRequest(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}
