package com.mrkrazyak.twittersentiment.service;

import com.mrkrazyak.twittersentiment.entity.Message;
import com.mrkrazyak.twittersentiment.entity.MessageRequest;
import com.mrkrazyak.twittersentiment.entity.User;
import com.mrkrazyak.twittersentiment.entity.response.MessageResponse;
import com.mrkrazyak.twittersentiment.entity.response.MessageResponseEntity;
import com.mrkrazyak.twittersentiment.repository.MessageRepository;
import com.mrkrazyak.twittersentiment.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        for (Message message : messages) {
            String username;
            String senderId = message.getSender().toString();
            Optional<User> sender = userRepository.findById(senderId);
            if (sender.isPresent()) {
                username = sender.get().getUsername();
            } else {
                username = "";
            }
            String text = message.getText();
            String timestamp = message.getTimestamp().toString();
            MessageResponseEntity responseEntity = new MessageResponseEntity(username, text, timestamp);
            responseEntities.add(responseEntity);
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
