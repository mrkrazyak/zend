package com.mrkrazyak.twittersentiment.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponseEntity {

    private String sender;
    private String text;
    private String timestamp;
    private List<String> readBy;

    public MessageResponseEntity() {}
    public MessageResponseEntity(String sender, String text, String timestamp) {
        this.sender = sender;
        this.text = text;
        this.timestamp = timestamp;
    }
    public MessageResponseEntity(String sender, String text, String timestamp, List<String> readBy) {
        this.sender = sender;
        this.text = text;
        this.timestamp = timestamp;
        this.readBy = readBy;
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
