package com.mrkrazyak.zend.service;

import com.mrkrazyak.zend.entity.request.FriendRequest;
import com.mrkrazyak.zend.entity.request.CreateFriendRequest;
import com.mrkrazyak.zend.repository.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendRequestService {

    @Autowired
    private FriendRequestRepository friendRequestRepository;
    @Autowired
    private UserService userService;

    public boolean createFriendRequest(CreateFriendRequest requestBody) {
        String senderId = requestBody.getSender();
        String recipientId = requestBody.getRecipient();
        if (!userService.userExists(senderId) ||
                !userService.userExists(recipientId)) {
            return false;
        }
        FriendRequest fr = new FriendRequest(senderId, recipientId);
        friendRequestRepository.save(fr);
        return true;
    }

}
