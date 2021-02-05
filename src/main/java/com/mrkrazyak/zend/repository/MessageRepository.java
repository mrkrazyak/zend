package com.mrkrazyak.zend.repository;

import com.mrkrazyak.zend.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    public List<Message> findByConversationId(String conversationId);

}
