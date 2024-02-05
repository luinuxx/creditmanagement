package com.codechallenge.creditmanagement.alta.repository;

import com.codechallenge.creditmanagement.alta.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
