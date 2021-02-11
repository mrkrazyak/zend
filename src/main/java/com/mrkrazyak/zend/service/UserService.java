package com.mrkrazyak.zend.service;

import com.mrkrazyak.zend.entity.User;
import com.mrkrazyak.zend.entity.request.LoginRequest;
import com.mrkrazyak.zend.entity.request.RegisterUserRequest;
import com.mrkrazyak.zend.entity.response.RegisterUserResponse;
import com.mrkrazyak.zend.exceptions.BadRequestException;
import com.mrkrazyak.zend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public RegisterUserResponse registerUser(RegisterUserRequest requestBody) {
        RegisterUserResponse response = new RegisterUserResponse();

        String username = requestBody.getUsername().toLowerCase();
        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new BadRequestException("Username already exists");
        }

        requestBody.setPassword(encoder.encode(requestBody.getPassword()));

        user = new User(username);
        user.setPassword(requestBody.getPassword());
        user = userRepository.save(user);

        response.setUsername(user.getUsername());
        return response;
    }

    public boolean login(LoginRequest requestBody) {
        // TODO: Implement login
        return true;
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
