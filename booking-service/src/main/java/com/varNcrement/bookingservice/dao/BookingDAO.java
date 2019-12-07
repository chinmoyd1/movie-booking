package com.varNcrement.bookingservice.dao;

import com.varNcrement.bookingservice.model.Booking;
import com.varNcrement.bookingservice.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BookingDAO {
    @Autowired
    BookingRepository bookingRepository;

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Page<Booking> getAllBookings(Specification specification, Pageable pageable){
        return bookingRepository.findAll(specification, pageable);
    }

    public Optional<Booking> findBookingById(long id){
        return bookingRepository.findById(id);
    }
}
