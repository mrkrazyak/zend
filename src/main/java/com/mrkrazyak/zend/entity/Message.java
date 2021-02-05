package com.mrkrazyak.zend.entity;

import org.bson.types.ObjectId;
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
    private ObjectId sender;
    private String text;
    private ObjectId conversationId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timestamp;
    private List<ObjectId> readBy;

    public Message() {}
    public Message(ObjectId sender, String text, ObjectId conversationId) {
        this.sender = sender;
        this.text = text;
        this.conversationId = conversationId;
        this.timestamp = new Date();
    }

    public String getId() {
        return id;
    }

    public ObjectId getSender() {
        return sender;
    }

    public void setSender(ObjectId sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ObjectId getConversationId() {
        return conversationId;
    }

    public void setConversationId(ObjectId conversationId) {
        this.conversationId = conversationId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<ObjectId> getReadBy() {
        return readBy;
    }

    public void setReadBy(List<ObjectId> readBy) {
        this.readBy = readBy;
    }

    public void addReadBy(ObjectId userId) {
        if (readBy == null) {
            readBy = new ArrayList<>();
        }
        readBy.add(userId);
    }
}
