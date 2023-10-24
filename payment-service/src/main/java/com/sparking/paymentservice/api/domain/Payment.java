package com.sparking.paymentservice.api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payments")
@RequiredArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private double amount;

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", orderId=" + orderId +
                ", amount=" + amount +
                '}';
    }
}
