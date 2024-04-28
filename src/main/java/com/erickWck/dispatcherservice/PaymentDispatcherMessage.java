package com.erickWck.dispatcherservice;

import java.math.BigDecimal;

public record PaymentDispatcherMessage(

        BigDecimal amount,
        String type,
        String cardNumber,
        String expiryDate,
        String cvv,
        String cardholderName

) {
    public static PaymentDispatcherMessage of(BigDecimal amount, String type,
                                              String cardNumber, String expiryDate,
                                              String cvv, String cardholderName) {
        return new PaymentDispatcherMessage(amount, type,
                cardNumber, expiryDate, cvv, cardholderName);
    }

    @Override
    public String toString() {
        return "PaymentDispatcherMessage{" +
                "amount=" + amount +
                ", type='" + type + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvv='" + cvv + '\'' +
                ", cardholderName='" + cardholderName + '\'' +
                '}';
    }
}