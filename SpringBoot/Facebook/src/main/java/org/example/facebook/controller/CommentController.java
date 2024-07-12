package org.example.facebook.controller;

import org.example.facebook.model.Comment;
import org.example.facebook.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    private ICommentService commentService;

//    public ResponseEntity<?> create(@PathVariable("productId") Integer productId, @PathVariable("customerId") Integer customerId, @RequestBody Comment comment) {
//
//    }

}
