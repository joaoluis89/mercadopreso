package com.mercadopreso.checkout.Gateway.remoting;

import com.mercadopreso.checkout.Gateway.Dtos.PaymentDto.PaymentRequestDto;
import com.mercadopreso.checkout.Gateway.Dtos.PaymentDto.PaymentResponseDto;
import com.mercadopreso.checkout.Gateway.client.PaymentClient;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentGateway {

    private final PaymentClient paymentClient;

    @Retry(name = "PaymentPreAuthorize") // Retenta X vezes por X tempo
    @CircuitBreaker(name = "PaymentPreAuthorize")
    public PaymentResponseDto preAuthorize(PaymentRequestDto paymentRequestDto) {
        return paymentClient.preAuthorize(paymentRequestDto);
    }
}
