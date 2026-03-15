package com.mercadopreso.checkout.Gateway.client;

import com.mercadopreso.checkout.Gateway.Dtos.PaymentDto.PaymentRequestDto;
import com.mercadopreso.checkout.Gateway.Dtos.PaymentDto.PaymentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment", url = "http://10.33.55.1:8080")
public interface PaymentClient {

    @PostMapping("/payment/pre-authorize")
    PaymentResponseDto preAuthorize(
            @RequestBody PaymentRequestDto payment
    );
}
