package com.example.notification_service.controller;

import com.example.notification_service.enums.Status;
import com.example.notification_service.model.Notification;
import com.example.notification_service.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create_notification")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification){
        return ResponseEntity.ok(notificationService.createNotification(notification));
    }

    @GetMapping("/{userId}")
    public List<Notification> getAllNotifications(@PathVariable Long userId){
        return notificationService.getAllUserNotification(userId);
    }

    @PatchMapping("/{id}")
    public void updateStatus(@PathVariable Long id, @RequestParam Status status){
        notificationService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id){
        notificationService.deleteNotification(id);
    }
}
