package com.varNcrement.bookingservice.service;

import com.varNcrement.bookingservice.model.Booking;
import com.varNcrement.bookingservice.model.dto.BookingDTO;

public interface IBookingManagement {

    public Booking createBooking(BookingDTO booking) throws Exception;
}
