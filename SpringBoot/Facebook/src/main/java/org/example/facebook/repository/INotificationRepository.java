package org.example.facebook.repository;

import org.example.facebook.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepository extends JpaRepository<Notification, Integer> {
}
