package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Notifications;

import java.util.List;


@Repository
public interface NotificationRepository extends CrudRepository<Notifications, Integer> {
    List<Notifications> findByToBeNotified(long toBeNotified);

    Notifications findById(int notificationId);

}
