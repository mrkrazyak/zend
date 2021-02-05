package com.mrkrazyak.zend.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Conversation {

    @Id
    private String id;
    private List<ObjectId> members;

    public Conversation() {
        this.members = new ArrayList<>();
    }
    public Conversation(List<ObjectId> members) {
        this.members = members;
    }

    public String getId() {
        return id;
    }

    public List<ObjectId> getMembers() {
        return members;
    }

    public void setMembers(List<ObjectId> users) {
        this.members = users;
    }

    public void addMember(ObjectId newUser) {
        this.members.add(newUser);
    }
}
