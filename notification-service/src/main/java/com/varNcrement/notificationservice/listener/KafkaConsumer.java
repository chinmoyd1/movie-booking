package com.varNcrement.notificationservice.listener;

import com.varNcrement.bookingservice.model.Booking;
import com.varNcrement.notificationservice.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    NotificationService notificationService;

    @KafkaListener
            (topics = "notifications", groupId = "notification_group",
        containerFactory = "kafkaListenerContainerFactory")
        public void consumeBooking(Booking booking){

            logger.info("Consuming Booking from Queue.");
            notificationService.sendNotification(booking);
        }
}
