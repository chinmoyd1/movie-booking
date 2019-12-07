package com.varNcrement.notificationservice.service;

import com.varNcrement.bookingservice.model.Booking;
import com.varNcrement.notificationservice.dao.NotificationDAO;
import com.varNcrement.notificationservice.document.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    NotificationDAO notificationDAO;

    public void sendNotification(Booking booking) {
        logger.info("Sending Notification to User.");

        System.out.println("Consumed JSON Message: "+ booking);

        Notification notification = new Notification(booking.getNotificationsID(),
                "Notified",new Date(),"Hi "+
                booking.getCustomerId()+" your ticket has been booked for movie "+booking.getMovieId()+" for seat no."+
                booking.getSeatSelectedID()+" at location "+ booking.getTheatreID());

        logger.info("Saving Notification in db.");
        notificationDAO.create(notification);
        logger.info("Notification Saved.");
    }


}
