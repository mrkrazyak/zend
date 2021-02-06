package com.mrkrazyak.zend.repository;

import com.mrkrazyak.zend.entity.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConversationRepository extends MongoRepository<Conversation, String> {

}
