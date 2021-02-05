package com.mrkrazyak.zend.service;

import com.mrkrazyak.zend.entity.Message;
import com.mrkrazyak.zend.entity.MessageRequest;
import com.mrkrazyak.zend.entity.User;
import com.mrkrazyak.zend.entity.response.MessageResponse;
import com.mrkrazyak.zend.entity.response.MessageResponseEntity;
import com.mrkrazyak.zend.repository.MessageRepository;
import com.mrkrazyak.zend.repository.UserRepository;
import org.bson.types.ObjectId;
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
        ObjectId conversationObjId = new ObjectId(conversationId);
        List<Message> messages = messageRepository.findByConversationId(conversationObjId);
        MessageResponse response = new MessageResponse();
        List<MessageResponseEntity> responseEntities = new ArrayList<>();
        Map<ObjectId, String> usernames = new HashMap<>();
        for (Message message : messages) {
            String username = usernames.get(message.getSender());
            if (username == null) {
                String senderId = message.getSender().toString();
                Optional<User> sender = userRepository.findById(senderId);
                username = sender.isPresent() ? sender.get().getUsername() : "";
                usernames.put(message.getSender(), username);
            }

            responseEntities.add(new MessageResponseEntity(username,
                    message.getText(),
                    message.getTimestamp().toString()));
        }
        response.setMessages(responseEntities);
        return response;
    }

    public boolean saveMessage(MessageRequest request) {
        String sender = request.getSender();
        String text = request.getText();
        String id = request.getConversationId();
        ObjectId conversationObjId = new ObjectId(id);
        ObjectId senderObjId = new ObjectId(sender);
        Message message = new Message(senderObjId, text, conversationObjId);
        messageRepository.save(message);
        return true;
    }

}
