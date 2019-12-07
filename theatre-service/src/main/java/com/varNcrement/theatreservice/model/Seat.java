package com.varNcrement.theatreservice.model;

public class Seat {
     private String movieId;

     private String locationID;

     private String theatreID;

     private String screenID;

     private String seatSelectedID;

     private boolean seatBooked;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getTheatreID() {
        return theatreID;
    }

    public void setTheatreID(String theatreID) {
        this.theatreID = theatreID;
    }

    public String getScreenID() {
        return screenID;
    }

    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }

    public String getSeatSelectedID() {
        return seatSelectedID;
    }

    public void setSeatSelectedID(String seatSelectedID) {
        this.seatSelectedID = seatSelectedID;
    }

    public boolean isSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(boolean seatBooked) {
        this.seatBooked = seatBooked;
    }
}
