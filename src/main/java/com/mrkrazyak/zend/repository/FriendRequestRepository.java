package com.mrkrazyak.zend.repository;

import com.mrkrazyak.zend.entity.FriendRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FriendRequestRepository extends MongoRepository<FriendRequest, String> {
}
