package org.example.facebook.repository;

import org.example.facebook.model.React;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReactRepository extends JpaRepository<React, Integer> {
}
