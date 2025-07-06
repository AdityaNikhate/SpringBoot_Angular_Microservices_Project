package com.adi.microservice.order.service.service;

import com.adi.microservice.order.service.client.InventoryClient;
import com.adi.microservice.order.service.dto.OrderRequest;
import com.adi.microservice.order.service.dto.OrderResponse;
import com.adi.microservice.order.service.model.Order;
import com.adi.microservice.order.service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderResponse placeOrder(OrderRequest orderRequest){
        boolean isInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if(isInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.skuCode());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
            log.info("{} : Order Created {}", this.getClass().getName(), order.getSkuCode());
            return new OrderResponse(order.getId(), order.getOrderNumber(), order.getSkuCode(), order.getPrice(), order.getQuantity());
        }else{
            log.error("The order is not in stock");
            throw new RuntimeException();
        }
    }
}
