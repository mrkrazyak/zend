package com.mrkrazyak.twittersentiment.service;

import com.mrkrazyak.twittersentiment.entity.Conversation;
import com.mrkrazyak.twittersentiment.repository.ConversationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    public boolean createConversation(List<String> memberIds) {
        Conversation conversation = new Conversation();
        for (String id : memberIds) {
            ObjectId memberId = new ObjectId(id);
            conversation.addMember(memberId);
        }
        conversation = conversationRepository.save(conversation);
        return true;
    }

}
