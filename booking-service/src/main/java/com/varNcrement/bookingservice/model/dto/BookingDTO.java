package com.varNcrement.bookingservice.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.varNcrement.bookingservice.commons.model.dto.GenericDTO;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO implements Serializable, GenericDTO {

    private long CustomerId;

    private long movieId;

    private String locationID;

    private long theatreID;

    private String screenID;

    private long seatSelectedID;

    private long reservationId;

    public BookingDTO() {
    }

    public long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
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
}
