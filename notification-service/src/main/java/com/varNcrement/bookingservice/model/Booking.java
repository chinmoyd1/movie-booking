package com.varNcrement.bookingservice.model;


public class Booking {

    private long bookingId;

    private long customerId;

    private long movieId;

    private String locationID;

    private long theatreID;

    private String screenID;

    private long seatSelectedID;

    private String paymentId;

    private long reservationId;

    private String activeStatus;

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

    public Booking() {
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", movieId=" + movieId +
                ", locationID='" + locationID + '\'' +
                ", theatreID=" + theatreID +
                ", screenID='" + screenID + '\'' +
                ", seatSelectedID=" + seatSelectedID +
                ", paymentId='" + paymentId + '\'' +
                ", reservationId=" + reservationId +
                ", activeStatus='" + activeStatus + '\'' +
                ", notificationsID='" + notificationsID + '\'' +
                '}';
    }
}
