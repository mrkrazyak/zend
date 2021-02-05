package com.mrkrazyak.zend.entity.response;

import java.util.List;

public class MessageResponse {

    private List<MessageResponseEntity> messages;

    public MessageResponse() {}
    public MessageResponse(List<MessageResponseEntity> messages) {
        this.messages = messages;
    }

    public List<MessageResponseEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageResponseEntity> messages) {
        this.messages = messages;
    }
}
