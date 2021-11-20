package com.moataz.miniproject.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "productName", types = { CustomerOrder.class })
public interface CustomerOrderInfo {
    public String getProductName();
}
