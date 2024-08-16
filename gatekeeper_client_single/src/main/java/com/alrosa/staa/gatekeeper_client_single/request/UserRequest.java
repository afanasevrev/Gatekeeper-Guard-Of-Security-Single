package com.alrosa.staa.gatekeeper_client_single.request;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private String company;
    private String cardId;
    private byte[] userPhoto;
    private String status;
    public UserRequest() {}
    public UserRequest(String firstName, String middleName, String lastName, String company, String cardId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.company = company;
        this.cardId = cardId;
    }
    public UserRequest(String status) {
        this.status = status;
    }
}
