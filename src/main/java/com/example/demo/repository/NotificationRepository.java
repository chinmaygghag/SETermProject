package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Notifications;


@Repository
public interface NotificationRepository extends CrudRepository<Notifications, Integer> {

}
