package com.example.demo.services;

import com.example.demo.models.Notifications;
import com.example.demo.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public void saveNotification(Notifications notifications){
        notificationRepository.save(notifications);
    }

    public List<Notifications> getNotificationsForUser(long id){
        return notificationRepository.findByToBeNotified(id);
    }

}
