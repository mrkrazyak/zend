package com.mrkrazyak.zend.service;

import com.mrkrazyak.zend.entity.FriendRequest;
import com.mrkrazyak.zend.entity.request.CreateFriendRequest;
import com.mrkrazyak.zend.repository.FriendRequestRepository;
import com.mrkrazyak.zend.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendRequestService {

    @Autowired
    private FriendRequestRepository friendRequestRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean createFriendRequest(CreateFriendRequest request) {
        if (!userRepository.findById(request.getSender()).isPresent() ||
                !userRepository.findById(request.getRecipient()).isPresent()) {
            return false;
        }
        ObjectId senderId = new ObjectId(request.getSender());
        ObjectId recipientId = new ObjectId(request.getRecipient());
        FriendRequest fr = new FriendRequest(senderId, recipientId);
        friendRequestRepository.save(fr);
        return true;
    }

}
