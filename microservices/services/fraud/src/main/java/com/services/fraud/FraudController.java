package com.services.fraud;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check/")
public class FraudController {

    private FraudCheckService fraudCheckService;

    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping ("/{customerId}/")
    public FraudCheckResponse isFraudster(@PathVariable Long customerId){
        boolean isFraudulentCustomer =  fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
