package org.example.facebook.repository;

import org.example.facebook.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface IPostRepository extends JpaRepository<Post, Integer> {
}
