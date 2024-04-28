package com.erickWck.dispatcherservice;

import java.math.BigDecimal;

public record PaymentDetails(

        BigDecimal amount,
        String type,
        String cardNumber,
        String expiryDate,
        String cvv,
        String cardholderName

) {
    public static PaymentDetails of(PaymentDispatcherMessage message) {
        return new PaymentDetails(message.amount(), message.type(),
                message.cardNumber(), message.expiryDate(), message.cvv(), message.cardholderName());
    }

}