package com.example.transaction;

import com.example.transaction.dto.FlightBookingAcknowledgement;
import com.example.transaction.dto.FlightBookingRequest;
import com.example.transaction.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class TransactionApplication {

    private final FlightBookingService flightBookingService;

    public TransactionApplication(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

    @PostMapping("/bookflight/")
    public FlightBookingAcknowledgement bookFlight(@RequestBody FlightBookingRequest flightBookingRequest){
        return flightBookingService.bookFlightTicket(flightBookingRequest);
    }

}
