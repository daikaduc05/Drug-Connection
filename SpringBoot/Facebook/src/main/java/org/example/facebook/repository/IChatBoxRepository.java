package org.example.facebook.repository;

import org.example.facebook.model.ChatBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChatBoxRepository extends JpaRepository<ChatBox, Integer> {
}
