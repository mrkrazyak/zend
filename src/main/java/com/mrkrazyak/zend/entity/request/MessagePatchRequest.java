package com.mrkrazyak.zend.entity.request;

import java.util.List;

public class MessagePatchRequest {

    private List<String> addToReadBy;

    public MessagePatchRequest() {}

    public List<String> getAddToReadBy() {
        return addToReadBy;
    }

    public void setAddToReadBy(List<String> addToReadBy) {
        this.addToReadBy = addToReadBy;
    }
}
