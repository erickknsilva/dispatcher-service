package com.erickWck.dispatcherservice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PaymentDetails(


        @NotNull(message = "Insira o valor total do produto.")
        @Positive(message = "O preço deve ser um número positovo.")
        BigDecimal amount,

        @NotBlank(message = "Insira o tipo do cartão credito ou debito")
        String type,

        @NotBlank(message = "Insira o numero do cartão")
        @Pattern(regexp = "^([0-9]{16})$", message = "O número do cartão está invalido.")
        String cardNumber,

        @NotBlank(message = "Insira a data de expiração")
        @Pattern(regexp = "^([0-9]{6})$", message = "A data de expiração deve conter só 6 numeros.")
        String expiryDate,

        @NotBlank(message = "Insira o código de segurançã do cartão")
        @Pattern(regexp = "^([0-9]{3})$", message = "O número do cartão está invalido.")
        String cvv,
        @NotBlank(message = "Insira o nome do responsavel pelo cartão.")
        String cardholderName,

        Long orderId

) {
    public static PaymentDetails of(PaymentDispatcherMessage message) {
        return new PaymentDetails(message.amount(), message.type(),
                message.cardNumber(), message.expiryDate(), message.cvv(), message.cardholderName(), message.orderId());
    }

}