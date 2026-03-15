package com.mercadopreso.checkout.Gateway.Controllers;

import com.mercadopreso.checkout.Gateway.Dtos.PaymentDto.PaymentRequestDto;
import com.mercadopreso.checkout.Gateway.Dtos.PaymentDto.PaymentResponseDto;
import com.mercadopreso.checkout.Gateway.Dtos.PlaceOrderDto.PlaceOrderRequestDto;
import com.mercadopreso.checkout.Gateway.remoting.PaymentGateway;
import com.mercadopreso.checkout.Services.PlaceOrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/place-order")
public class PlaceOrderController {
    private final PlaceOrderService placeOrderService;
    private final PaymentGateway paymentGateway;

    @PostMapping
    public ResponseEntity<PaymentResponseDto> placeOrder(@RequestBody @Valid PlaceOrderRequestDto placeOrderRequestDto) {
        PaymentResponseDto paymentResponseDto = placeOrderService.placeOrder(
                placeOrderRequestDto.getCart(),
                placeOrderRequestDto.getPayment()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentResponseDto);
    }


    @GetMapping("/checkout-pre-authorize")
    public PaymentResponseDto preAuthorizePayment() {
        PaymentResponseDto paymentResponseDto = paymentGateway.preAuthorize(
                PaymentRequestDto.builder()
                        .type("CARTAO_CREDITO")
                        .gateway("PAGSEGURO")
                        .amount(BigDecimal.valueOf(100L))
                        .userId(UUID.randomUUID().toString())
                        .build()
        );
        return paymentResponseDto;
    }
}
