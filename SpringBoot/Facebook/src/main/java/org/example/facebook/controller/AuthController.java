package org.example.facebook.controller;

import org.example.facebook.dto.JWTAuthResponse;
import org.example.facebook.dto.LoginDTO;
import org.example.facebook.dto.RegisterDTO;
import org.example.facebook.security.CustomUserDetailsService;
import org.example.facebook.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private IAuthService authService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    // Build Login REST API
    @PostMapping(value = {"/login", "/sign-in"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDTO loginDto) {
        String token = authService.login(loginDto);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginDto.getUsernameOrEmail());

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse(token, userDetails.getAuthorities());
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setRoleList(userDetails.getAuthorities());

        return ResponseEntity.ok(jwtAuthResponse);
    }
    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto) {

        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
