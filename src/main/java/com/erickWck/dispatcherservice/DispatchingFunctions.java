package com.erickWck.dispatcherservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Configuration
public class DispatchingFunctions {

    private static final Logger log = LoggerFactory.getLogger(DispatchingFunctions.class);

    @Bean
    Function<Flux<PaymentDispatcherMessage>, Flux<PaymentDetails>> sendPaymentService() {

        return paymentDispatcherMessage ->
                paymentDispatcherMessage.map(details -> {
                    log.info("Enviando o detalhes de pagamento para a processadora {}" + details.toString());
                    return PaymentDetails.of(details);
                });

    }


}
