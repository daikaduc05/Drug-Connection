package org.example.facebook.service;

import org.example.facebook.model.Post;

public interface IPostService {
    void save(Post post);
    void delete(Post post);
}
