package com.moataz.miniproject.services;

import com.moataz.miniproject.entities.Customer;
import com.moataz.miniproject.entities.CustomerOrder;


import java.util.List;

public interface OrderService {


    List<CustomerOrder> findCustomerOrdersByProductName(String productName);
    List<CustomerOrder> findAll();
    CustomerOrder findById(Long orderId);
    CustomerOrder Create(CustomerOrder order);
    CustomerOrder Modify(CustomerOrder order);
    void DeleteById(Long orderId);
    List<CustomerOrder> findCustomerOrdersByProductNameContains(String productName);
    List<CustomerOrder> findCustomerOrdersByProductNameAndPrice(String productName,double price);
    List<CustomerOrder> findByOrderByProductNameAsc();
    List<CustomerOrder> findByOrderByProductNameAscPriceDesc();
    List<CustomerOrder> findCustomerOrdersByCust(Customer customer);
    List<CustomerOrder> findCustomerOrdersByCust_CustomerId(Long customerId);
}
