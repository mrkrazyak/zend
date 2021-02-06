package com.mrkrazyak.zend.service;

import com.mrkrazyak.zend.entity.Conversation;
import com.mrkrazyak.zend.entity.Message;
import com.mrkrazyak.zend.entity.request.MessagePatchRequest;
import com.mrkrazyak.zend.entity.request.MessageRequest;
import com.mrkrazyak.zend.entity.User;
import com.mrkrazyak.zend.entity.response.MessageResponse;
import com.mrkrazyak.zend.entity.response.MessageResponseEntity;
import com.mrkrazyak.zend.exceptions.BadRequestException;
import com.mrkrazyak.zend.exceptions.NotFoundException;
import com.mrkrazyak.zend.repository.MessageRepository;
import com.mrkrazyak.zend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ConversationService conversationService;

    public MessageResponse getMessages(String conversationId) {
        Optional<Conversation> conversationOpt = conversationService.findConversationById(conversationId);
        if (!conversationOpt.isPresent()) {
            throw new NotFoundException("conversationId [" + conversationId + "]");
        }

        List<Message> messages = messageRepository.findByConversationId(conversationId);

        MessageResponse response = new MessageResponse();
        List<MessageResponseEntity> responseEntities = new ArrayList<>();
        Map<String, String> usernames = new HashMap<>();
        for (Message message : messages) {
            String username = usernames.get(message.getSenderId());
            if (username == null) {
                String senderId = message.getSenderId();
                Optional<User> sender = userService.findUserById(senderId);
                username = sender.isPresent() ? sender.get().getUsername() : "";
                usernames.put(message.getSenderId(), username);
            }

            List<String> readByUsers = new ArrayList<>();
            if (!CollectionUtils.isEmpty(message.getReadByIds())) {
                for (String readById : message.getReadByIds()) {
                    String readByUser = usernames.get(readById);
                    if (readByUser == null) {
                        Optional<User> readByUserOpt = userService.findUserById(readById);
                        if (readByUserOpt.isPresent()) {
                            User user = readByUserOpt.get();
                            readByUser = StringUtils.hasText(user.getUsername()) ? user.getUsername() : "";
                            usernames.put(readById, readByUser);
                        }
                    }
                    if (StringUtils.hasText(readByUser)) {
                        readByUsers.add(readByUser);
                    }

                }
            }
            responseEntities.add(new MessageResponseEntity(message.getId(),
                    username,
                    message.getText(),
                    message.getTimestamp().toString(),
                    readByUsers));
        }
        response.setMessages(responseEntities);
        return response;
    }

    public boolean saveMessage(MessageRequest requestBody) {
        // TODO: Validate that sender is in conversation
        String senderId = requestBody.getSenderId();
        String text = requestBody.getText();
        String conversationId = requestBody.getConversationId();
        Message message = new Message(senderId, text, conversationId);
        messageRepository.save(message);
        return true;
    }

    public boolean updateMessage(String messageId, MessagePatchRequest requestBody) {
        Optional<Message> messageOpt = findMessageById(messageId);
        if (!messageOpt.isPresent()) {
            throw new NotFoundException(String.format("messageId [%s]", messageId));
        }
        Message message = messageOpt.get();

        if (!CollectionUtils.isEmpty(requestBody.getAddToReadBy())) {
            List<String> userIdsToAdd = new ArrayList<>();
            for (String username : requestBody.getAddToReadBy()) {
                User user = userService.findUserByUsername(username);
                if (user == null) {
                    throw new NotFoundException(String.format("username [%s]", username));
                }
                userIdsToAdd.add(user.getId());
            }
            message.addReadBy(userIdsToAdd);
        }
        messageRepository.save(message);
        return true;
    }

    public Optional<Message> findMessageById(String messageId) {
        return messageRepository.findById(messageId);
    }

}
