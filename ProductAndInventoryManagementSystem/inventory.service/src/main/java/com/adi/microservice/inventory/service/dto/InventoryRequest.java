package com.adi.microservice.inventory.service.dto;

public record InventoryRequest(Long Id, String skuCode, Integer quantity) {
}
