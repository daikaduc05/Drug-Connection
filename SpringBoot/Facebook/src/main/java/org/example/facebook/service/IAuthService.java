package org.example.facebook.service;

import org.example.facebook.dto.LoginDTO;
import org.example.facebook.dto.RegisterDTO;


public interface IAuthService {
    String login(LoginDTO loginDto);

    String register(RegisterDTO registerDto);
}
