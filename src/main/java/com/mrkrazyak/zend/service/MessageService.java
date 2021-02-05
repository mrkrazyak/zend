package com.mrkrazyak.zend.service;

import com.mrkrazyak.zend.entity.Message;
import com.mrkrazyak.zend.entity.request.MessageRequest;
import com.mrkrazyak.zend.entity.User;
import com.mrkrazyak.zend.entity.response.MessageResponse;
import com.mrkrazyak.zend.entity.response.MessageResponseEntity;
import com.mrkrazyak.zend.repository.MessageRepository;
import com.mrkrazyak.zend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;

    public MessageResponse getMessages(String conversationId) {
        List<Message> messages = messageRepository.findByConversationId(conversationId);
        MessageResponse response = new MessageResponse();
        List<MessageResponseEntity> responseEntities = new ArrayList<>();
        Map<String, String> usernames = new HashMap<>();
        for (Message message : messages) {
            String username = usernames.get(message.getSenderId());
            if (username == null) {
                String senderId = message.getSenderId().toString();
                Optional<User> sender = userRepository.findById(senderId);
                username = sender.isPresent() ? sender.get().getUsername() : "";
                usernames.put(message.getSenderId(), username);
            }

            responseEntities.add(new MessageResponseEntity(username,
                    message.getText(),
                    message.getTimestamp().toString()));
        }
        response.setMessages(responseEntities);
        return response;
    }

    public boolean saveMessage(MessageRequest request) {
        // TODO: Validate that sender is in conversation
        String senderId = request.getSenderId();
        String text = request.getText();
        String conversationId = request.getConversationId();
        Message message = new Message(senderId, text, conversationId);
        messageRepository.save(message);
        return true;
    }

}
