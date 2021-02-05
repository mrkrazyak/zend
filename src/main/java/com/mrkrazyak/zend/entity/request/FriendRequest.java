package com.mrkrazyak.zend.entity.request;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document
public class FriendRequest {

    @Id
    private String id;
    private String senderUserId;
    private String recipientUserId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timestamp;

    public FriendRequest() {}
    public FriendRequest(String senderUserId, String recipientUserId) {
        this.senderUserId = senderUserId;
        this.recipientUserId = recipientUserId;
        this.timestamp = new Date();
    }

    public String getId() {
        return id;
    }

    public String getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(String senderUserId) {
        this.senderUserId = senderUserId;
    }

    public String getRecipientUserId() {
        return recipientUserId;
    }

    public void setRecipientUserId(String recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
