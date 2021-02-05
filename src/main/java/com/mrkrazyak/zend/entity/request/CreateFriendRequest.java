package com.mrkrazyak.zend.entity.request;

public class CreateFriendRequest {

    private String sender;
    private String recipient;

    public CreateFriendRequest() {}
    public CreateFriendRequest(String sender, String recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
