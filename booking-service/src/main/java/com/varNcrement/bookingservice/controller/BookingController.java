package com.varNcrement.bookingservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.varNcrement.bookingservice.commons.service.context.ContextService;
import com.varNcrement.bookingservice.commons.wrapper.GenericResult;
import com.varNcrement.bookingservice.model.Booking;
import com.varNcrement.bookingservice.model.dto.BookingDTO;
import com.varNcrement.bookingservice.service.IBookingManagement;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = {"Booking"})
@RestController
@RequestMapping("/booking")
public class BookingController extends ContextService{

    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    IBookingManagement bookingManagement;

    @Autowired
    private HttpServletRequest request;

    @PostMapping()
    @HystrixCommand(fallbackMethod = "createBookingFallback",
        commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" , value = "2000"),
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" , value = "5"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" , value = "50"),
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" , value = "5000"),
        })
    @ApiOperation(value = "Create a new Booking")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = BookingDTO.class),
            @ApiResponse(code = 201, message = "Created", response = BookingDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity createBooking(@RequestBody BookingDTO data) throws Exception {
        logger.info("\nCreating a new Booking for user from details passed.");

        GenericResult genericResult = new GenericResult();

        Booking booking = bookingManagement.createBooking(data);

        genericResult.setStatus("Success");
        genericResult.setHttpStatus(HttpStatus.OK);
        genericResult.setResult(booking);

        return genericResult.getGenericResult();
    }

    public ResponseEntity createBookingFallback(@RequestBody BookingDTO data) throws Exception {
        GenericResult genericResult = new GenericResult();

        genericResult.setStatus("Failure");
        genericResult.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        genericResult.setMessage("Services are down for now, please try after some time.");

        return genericResult.getGenericResult();
    }

}
