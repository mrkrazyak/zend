package com.mrkrazyak.twittersentiment.service;

import com.mrkrazyak.twittersentiment.entity.User;
import com.mrkrazyak.twittersentiment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
