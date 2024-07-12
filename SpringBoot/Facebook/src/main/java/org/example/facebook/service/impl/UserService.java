package org.example.facebook.service.impl;

import org.example.facebook.model.User;
import org.example.facebook.repository.IUserRepository;
import org.example.facebook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public User showUsername(String username) {
        return userRepository.showUsername(username);
    }
}
