package org.example.facebook.service;

import org.example.facebook.model.User;
import org.springframework.data.repository.query.Param;

public interface IUserService {
    User showUsername(String username);
}
