package com.mrkrazyak.zend.entity.request;

public class CreateUserRequest {

    private String username;

    public CreateUserRequest() {}
    public CreateUserRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
