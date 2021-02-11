package com.mrkrazyak.zend.entity.response;

public class RegisterUserResponse extends ZendResponse {

    private String username;

    public RegisterUserResponse() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
