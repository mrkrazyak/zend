package com.mrkrazyak.zend.repository;

import com.mrkrazyak.zend.entity.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationRepository extends MongoRepository<Conversation, String> {
}
