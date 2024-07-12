package org.example.facebook.repository;

import org.example.facebook.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {
//    List<Comment> findCommentByContent

//    List<Comment> findByProduct_IdAndCustomer_Id();

}
