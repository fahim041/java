package com.example.transaction.repository;

import com.example.transaction.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
