package com.mrkrazyak.zend.service;

import com.mrkrazyak.zend.entity.Conversation;
import com.mrkrazyak.zend.entity.request.CreateConversationRequest;
import com.mrkrazyak.zend.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;
    @Autowired
    private UserService userService;

    public boolean createConversation(CreateConversationRequest requestBody) {
        Conversation conversation = new Conversation();
        for (String memberId : requestBody.getMemberIds()) {
            if (!userService.userExists(memberId)){
                return false;
            }
            conversation.addMember(memberId);
        }
        conversation = conversationRepository.save(conversation);
        return true;
    }

    public Optional<Conversation> findConversationById(String conversationId) {
        return conversationRepository.findById(conversationId);
    }

}
