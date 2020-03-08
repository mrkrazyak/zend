package com.mrkrazyak.twittersentiment.service;

import com.mrkrazyak.twittersentiment.entity.Message;
import com.mrkrazyak.twittersentiment.entity.MessageRequest;
import com.mrkrazyak.twittersentiment.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessages(String chatRoom) {
        List<Message> chatRoomMessages = messageRepository.findByChatRoom(chatRoom);
        return chatRoomMessages;
    }

    public boolean saveMessage(MessageRequest request) {
        String sender = request.getSender();
        String content = request.getContent();
        String chatRoom = request.getChatRoom();
        Message message = new Message(sender, content, chatRoom);
        messageRepository.save(message);

        return true;
    }

}
