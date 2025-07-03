package com.adi.microservice.order.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
/*
* @Author Aditya Nikhate
*/

@Entity
@Table(name="t_order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private String skuCode; //skuKeepCode
    private BigDecimal price;
    private Integer quantity;
}
