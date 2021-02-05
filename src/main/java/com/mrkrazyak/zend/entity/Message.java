package com.mrkrazyak.zend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class Message {

    @Id
    private String id;
    private String senderId;
    private String text;
    private String conversationId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timestamp;
    private List<String> readByIds;

    public Message() {}
    public Message(String senderId, String text, String conversationId) {
        this.senderId = senderId;
        this.text = text;
        this.conversationId = conversationId;
        this.timestamp = new Date();
    }

    public String getId() {
        return id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getReadByIds() {
        return readByIds;
    }

    public void setReadByIds(List<String> readByIds) {
        this.readByIds = readByIds;
    }

    public void addReadBy(String userId) {
        if (readByIds == null) {
            readByIds = new ArrayList<String>();
        }
        readByIds.add(userId);
    }
}
