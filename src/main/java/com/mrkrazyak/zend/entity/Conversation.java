package com.mrkrazyak.zend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Conversation {

    @Id
    private String id;
    private List<String> members;

    public Conversation() {
        this.members = new ArrayList<String>();
    }
    public Conversation(List<String> members) {
        this.members = members;
    }

    public String getId() {
        return id;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> users) {
        this.members = users;
    }

    public void addMember(String newUser) {
        this.members.add(newUser);
    }
}
