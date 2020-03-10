package com.mrkrazyak.twittersentiment.repository;

import com.mrkrazyak.twittersentiment.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);

}
