package com.mrkrazyak.zend.repository;

import com.mrkrazyak.zend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);

}
