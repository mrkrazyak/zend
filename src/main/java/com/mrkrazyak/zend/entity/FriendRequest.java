package com.mrkrazyak.zend.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document
public class FriendRequest {

    @Id
    private String id;
    private ObjectId sender;
    private ObjectId recipient;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timestamp;

    public FriendRequest() {}
    public FriendRequest(ObjectId sender, ObjectId recipient) {
        this.sender = sender;
        this.recipient = recipient;
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

    public ObjectId getRecipient() {
        return recipient;
    }

    public void setRecipient(ObjectId recipient) {
        this.recipient = recipient;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
