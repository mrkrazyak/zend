package com.mrkrazyak.zend.service;

import com.mrkrazyak.zend.entity.User;
import com.mrkrazyak.zend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean createUser(String username) {
        boolean created = false;
        User user = userRepository.findByUsername(username);
        if (user == null) {
            user = new User(username);
            user = userRepository.save(user);
            created = true;
        }
        return created;
    }

    public boolean userExists(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.isPresent();
    }

    public Optional<User> findUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
