package com.adi.microservice.inventory.service.service;

import com.adi.microservice.inventory.service.dto.InventoryRequest;
import com.adi.microservice.inventory.service.model.Inventory;
import com.adi.microservice.inventory.service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity){
        log.info("{} isInStock called", this.getClass().getName());
        return inventoryRepository.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
    }
}
