package org.example.facebook.service.impl;

import org.example.facebook.model.Comment;
import org.example.facebook.repository.ICommentRepository;
import org.example.facebook.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }


}
