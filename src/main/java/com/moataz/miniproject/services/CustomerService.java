package com.moataz.miniproject.services;

import com.moataz.miniproject.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findCustomersByCustomerName(String name);
    List<Customer> findAll();
    Customer Create(Customer customer);
    Customer Modify(Customer customer);
    void DeleteById(Long customerId);
    List<Customer> findCustomersByCustomerNameContains(String customerName);
    Customer findCustomerById(Long id);


}
