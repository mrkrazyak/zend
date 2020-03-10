package com.mrkrazyak.twittersentiment.repository;

import com.mrkrazyak.twittersentiment.entity.Conversation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationRepository extends MongoRepository<Conversation, String> {
}
