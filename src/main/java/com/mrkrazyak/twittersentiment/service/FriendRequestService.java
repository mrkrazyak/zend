package com.mrkrazyak.twittersentiment.service;

import com.mrkrazyak.twittersentiment.entity.FriendRequest;
import com.mrkrazyak.twittersentiment.entity.request.CreateFriendRequest;
import com.mrkrazyak.twittersentiment.repository.FriendRequestRepository;
import com.mrkrazyak.twittersentiment.repository.UserRepository;
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
