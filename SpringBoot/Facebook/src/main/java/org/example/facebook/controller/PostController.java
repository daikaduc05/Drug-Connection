package org.example.facebook.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.facebook.dto.PostCreateDTO;
import org.example.facebook.model.Post;
import org.example.facebook.service.IPostService;
import org.example.facebook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private IPostService postService;
    @Autowired
    private IUserService userService;

    @PostMapping("")
    public ResponseEntity<?> create (@RequestBody PostCreateDTO postCreateDTO, Authentication authentication) {
//        User user = userService.showUsername(authentication.name());
        Post post = new Post();
//        post.setUser(user);
        post.setTitle(postCreateDTO.getTitle());
        post.setBody(postCreateDTO.getBody());
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
