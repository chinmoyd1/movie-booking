package com.varNcrement.notificationservice.dao;

import com.varNcrement.bookingservice.model.Booking;
import com.varNcrement.notificationservice.document.Notification;
import com.varNcrement.notificationservice.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationDAOImpl implements NotificationDAO<Notification, String>{

    @Autowired
    NotificationRepo notificationRepo;

    @Override
    public void create(Notification notification) {
        notificationRepo.save(notification);
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepo.findAll();
    }
}
