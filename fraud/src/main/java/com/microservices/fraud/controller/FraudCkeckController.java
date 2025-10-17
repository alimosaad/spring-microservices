package com.microservices.fraud.controller;

import com.microservices.fraud.services.FraudCheckResponse;
import com.microservices.fraud.services.FraudService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudCkeckController {
    private final FraudService fraudService;
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse fraudCheckResponse(@PathVariable("customerId") long customerId){
        boolean isFraudulentCustomer =fraudService.isFraudCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}
