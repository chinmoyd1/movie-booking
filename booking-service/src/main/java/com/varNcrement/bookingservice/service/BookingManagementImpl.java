package com.varNcrement.bookingservice.service;

import com.varNcrement.bookingservice.dao.BookingDAO;
import com.varNcrement.bookingservice.model.Booking;
import com.varNcrement.bookingservice.model.dto.BookingDTO;
import com.varNcrement.bookingservice.model.dto.SeatDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.Random;

@Service
public class BookingManagementImpl implements IBookingManagement{

    private static final Logger logger = LoggerFactory.getLogger(BookingManagementImpl.class);

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private KafkaTemplate<String, Booking> kafkaTemplate;

    @Autowired
    RestTemplate restTemplate;

    private static final String TOPIC = "notifications";

    @Override
    public Booking createBooking(BookingDTO bookingDTO) throws Exception{
        logger.info("Entering Method : [createBooking]");

        Booking booking = new Booking();

        booking.setCustomerId(bookingDTO.getCustomerId());
        booking.setLocationID(bookingDTO.getLocationID());
        booking.setMovieId(bookingDTO.getMovieId());
        booking.setScreenID(bookingDTO.getScreenID());
        booking.setTheatreID(bookingDTO.getTheatreID());
        booking.setSeatSelectedID(bookingDTO.getSeatSelectedID());
        booking.setReservationId(bookingDTO.getReservationId());

        //Check if selected seat is available
        logger.info("Checking seat availability...");

        SeatDTO seat = restTemplate.getForObject("http://theatre-service/theatre/booking/"
                +bookingDTO.getLocationID()+"/"+bookingDTO.getTheatreID()+"/"+
                        bookingDTO.getScreenID()+"/"+bookingDTO.getMovieId()+"/"+bookingDTO.getSeatSelectedID(),
                SeatDTO.class);
        logger.info("Response from theatre API : "+seat);
        logger.info("Seat Booking Status: [SeatBooked : "+seat.isSeatBooked()+"]");
        if(seat.isSeatBooked()){
            throw new RuntimeException("Please Change the Seat as its already Booked.");
        }

        Random random = new Random();
        booking.setActiveStatus("Active");

        long randSeq = (long)(Math.random()*1000000);
        booking.setPaymentId("P"+randSeq);
        booking.setNotificationsID("N"+randSeq);

        bookingDAO.save(booking);

        Optional<Booking> optBooking = bookingDAO.findBookingById(booking.getBookingId());
        if(optBooking.isPresent()){
            booking = optBooking.get();
        }

        kafkaTemplate.send(TOPIC, booking);

        logger.info("Exiting Method : [createBooking]");
        return booking;
    }
}

