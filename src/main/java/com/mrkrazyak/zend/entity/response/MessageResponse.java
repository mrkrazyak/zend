package com.mrkrazyak.zend.entity.response;

import java.util.ArrayList;
import java.util.List;

public class MessageResponse extends ZendResponse {

    private List<MessageResponseEntity> messages = new ArrayList<>();

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
