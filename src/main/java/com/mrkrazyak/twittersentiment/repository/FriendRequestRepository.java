package com.mrkrazyak.twittersentiment.repository;

import com.mrkrazyak.twittersentiment.entity.FriendRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FriendRequestRepository extends MongoRepository<FriendRequest, String> {
}
