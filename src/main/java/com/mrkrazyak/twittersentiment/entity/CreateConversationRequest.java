package com.mrkrazyak.twittersentiment.entity;

import java.util.List;

public class CreateConversationRequest {

    private List<String> memberIds;

    public List<String> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }
}
