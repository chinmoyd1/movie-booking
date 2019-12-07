package com.varNcrement.notificationservice.repository;

import com.varNcrement.notificationservice.document.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepo extends MongoRepository<Notification, String> {

    @Override
    Notification save(Notification notification);

    @Override
    List<Notification> findAll();
}
