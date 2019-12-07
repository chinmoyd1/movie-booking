package com.varNcrement.theatreservice.controller;


import com.varNcrement.theatreservice.model.Seat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);

    @GetMapping("/booking/{locationID}/{theatreID}/{screenID}/{movieID}/{seatSelectedID}")
    public Seat checkSeatAvailability(@PathVariable(value = "locationID") String locationID,
                                      @PathVariable(value = "theatreID") String theatreID,
                                      @PathVariable(value = "screenID") String screenID,
                                      @PathVariable(value = "movieID") String movieID,
                                      @PathVariable(value = "seatSelectedID") String seatSelectedID) {
        logger.info("Inside Method : [checkSeatAvailability]");

        Seat seat = new Seat();
        seat.setLocationID(locationID);
        seat.setSeatSelectedID(seatSelectedID);
        seat.setTheatreID(theatreID);
        seat.setScreenID(screenID);
        seat.setMovieId(movieID);
        //Should check whether the seat exists or not.
        logger.info("Checking Seat availability...");
        seat.setSeatBooked(false);
        logger.info("Seat Booking Status: [SeatBooked : "+seat.isSeatBooked()+"]");

        logger.info("Exiting Method : [checkSeatAvailability]");
        return seat;
    }

}
