package org.example.facebook.repository;

import org.example.facebook.model.Messenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessengerRepository extends JpaRepository<Messenger, Integer> {
}
