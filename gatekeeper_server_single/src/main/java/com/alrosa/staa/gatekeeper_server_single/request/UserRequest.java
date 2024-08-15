package com.alrosa.staa.gatekeeper_server_single.request;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserRequest {
    private String status;
    public UserRequest() {}
    public UserRequest(String status) {
        this.status = status;
    }
}
