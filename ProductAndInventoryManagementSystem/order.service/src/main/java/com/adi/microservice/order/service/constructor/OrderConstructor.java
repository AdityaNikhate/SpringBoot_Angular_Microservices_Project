package com.adi.microservice.order.service.constructor;

import com.adi.microservice.order.service.dto.OrderRequest;
import com.adi.microservice.order.service.dto.OrderResponse;
import com.adi.microservice.order.service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderConstructor {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest){
        return orderService.placeOrder(orderRequest);
    }
}
