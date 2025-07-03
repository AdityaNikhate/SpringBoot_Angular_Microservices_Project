package com.adi.microservice.order.service.dto;

import java.math.BigDecimal;

public record OrderRequest(Long id, String orderNumber, String skuCode, BigDecimal price, Integer quantity) {
}
