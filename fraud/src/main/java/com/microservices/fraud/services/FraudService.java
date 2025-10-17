package com.microservices.fraud.services;

import com.microservices.fraud.model.FraudCheckHistory;
import com.microservices.fraud.repositories.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudCustomer(long customerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.
                        builder()
                        .customerId(customerId)
                        .isFraud(false)
                        .createdAt(LocalDateTime.now())
                        .build());
        return false;
    }
}
