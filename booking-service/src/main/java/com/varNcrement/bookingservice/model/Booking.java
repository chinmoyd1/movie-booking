package com.varNcrement.bookingservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private long bookingId;

    @NotNull
    @Column(name = "customer_id")
    private long customerId;

    @NotNull
    @Column(name = "movie_id")
    private long movieId;

    @NotEmpty
    @Column(name = "location_id")
    private String locationID;

    @NotNull
    @Column(name = "theatre_id")
    private long theatreID;

    @NotEmpty
    @Column(name = "screen_id")
    private String screenID;

    @NotNull
    @Column(name = "seat_selected_id")
    private long seatSelectedID;

    @NotEmpty
    @Column(name = "payment_id")
    private String paymentId;

    @NotNull
    @Column(name = "reservation_id")
    private long reservationId;

    @NotEmpty
    @Column(name = "active_status")
    private String activeStatus;

    @NotEmpty
    @Column(name = "notifications_id")
    private String notificationsID;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getNotificationsID() {
        return notificationsID;
    }

    public void setNotificationsID(String notificationsID) {
        this.notificationsID = notificationsID;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public long getTheatreID() {
        return theatreID;
    }

    public void setTheatreID(long theatreID) {
        this.theatreID = theatreID;
    }

    public String getScreenID() {
        return screenID;
    }

    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }

    public long getSeatSelectedID() {
        return seatSelectedID;
    }

    public void setSeatSelectedID(long seatSelectedID) {
        this.seatSelectedID = seatSelectedID;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

}
