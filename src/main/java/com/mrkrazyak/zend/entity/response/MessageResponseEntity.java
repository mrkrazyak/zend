package com.mrkrazyak.zend.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponseEntity {

    private String messageId;
    private String sender;
    private String text;
    private String timestamp;
    private List<String> readBy;

    public MessageResponseEntity() {}
    public MessageResponseEntity(String messageId, String sender, String text, String timestamp) {
        this.messageId = messageId;
        this.sender = sender;
        this.text = text;
        this.timestamp = timestamp;
    }
    public MessageResponseEntity(String messageId, String sender, String text, String timestamp, List<String> readBy) {
        this.messageId = messageId;
        this.sender = sender;
        this.text = text;
        this.timestamp = timestamp;
        this.readBy = readBy;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getReadBy() {
        return readBy;
    }

    public void setReadBy(List<String> readBy) {
        this.readBy = readBy;
    }
}
