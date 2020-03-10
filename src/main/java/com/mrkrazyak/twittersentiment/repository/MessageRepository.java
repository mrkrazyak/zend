package com.mrkrazyak.twittersentiment.repository;

import com.mrkrazyak.twittersentiment.entity.Message;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    public List<Message> findByConversationId(ObjectId conversationId);

}
