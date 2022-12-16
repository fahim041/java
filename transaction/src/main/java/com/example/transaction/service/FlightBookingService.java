package com.example.transaction.service;

import com.example.transaction.dto.FlightBookingAcknowledgement;
import com.example.transaction.dto.FlightBookingRequest;
import com.example.transaction.entity.PassengerInfo;
import com.example.transaction.entity.PaymentInfo;
import com.example.transaction.repository.PassengerInfoRepository;
import com.example.transaction.repository.PaymentInfoRepository;
import com.example.transaction.utils.PaymentUtils;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightBookingService {

    private final PassengerInfoRepository passengerInfoRepository;

    private final PaymentInfoRepository paymentInfoRepository;

    public FlightBookingService(PassengerInfoRepository passengerInfoRepository, PaymentInfoRepository paymentInfoRepository) {
        this.passengerInfoRepository = passengerInfoRepository;
        this.paymentInfoRepository = paymentInfoRepository;
    }

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(passengerInfo);
        return new FlightBookingAcknowledgement("success", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
