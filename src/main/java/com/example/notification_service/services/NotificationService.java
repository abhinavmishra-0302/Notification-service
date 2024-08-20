package com.example.notification_service.services;

import com.example.notification_service.enums.Status;
import com.example.notification_service.model.Notification;
import com.example.notification_service.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification){
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllUserNotification(Long userId){

        return notificationRepository.findByUserId(userId);
    }

    public void deleteNotification(Long id){
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found!"));

        notificationRepository.delete(notification);
    }

    public void updateStatus(Long id, Status status){
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setStatus(status);

        notificationRepository.save(notification);
    }
}
