package com.varNcrement.bookingservice.repo;

import com.varNcrement.bookingservice.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long>, JpaSpecificationExecutor<Booking>, PagingAndSortingRepository<Booking, Long> {

    @Override
    Booking save(Booking s);

    @Override
    Page<Booking> findAll(Specification specification, Pageable pageable);

    @Override
    Optional<Booking> findById(Long aLong);
}
