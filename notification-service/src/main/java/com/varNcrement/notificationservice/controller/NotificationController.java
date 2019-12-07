package com.varNcrement.notificationservice.controller;

import com.varNcrement.notificationservice.dao.NotificationDAO;
import com.varNcrement.notificationservice.document.Notification;
import com.varNcrement.notificationservice.repository.NotificationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    NotificationDAO notificationDAO;

    @GetMapping()
    public List<Notification> getAllNotifications(){
        logger.info("Fetching All Notifications.");
        return notificationDAO.getAll();
    }

}
