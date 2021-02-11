package com.mrkrazyak.zend.entity.request;

public class RegisterUserRequest {

    private String username;
    private String password;

    public RegisterUserRequest() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
