package com.moataz.miniproject.services;


import com.moataz.miniproject.entities.Customer;
import com.moataz.miniproject.entities.CustomerOrder;
import com.moataz.miniproject.repositories.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    CustomerOrderRepository OrderRepo;




    @Override
    public List<CustomerOrder> findCustomerOrdersByProductName(String productName) {
        return OrderRepo.findCustomerOrdersByProductName(productName);
    }

    @Override
    public List<CustomerOrder> findAll() {
        return OrderRepo.findAll();
    }

    @Override
    public CustomerOrder findById(Long orderId) {
        return OrderRepo.getById(orderId);
    }

    @Override
    public CustomerOrder Create(CustomerOrder order) {
        return OrderRepo.save(order);
    }

    @Override
    public CustomerOrder Modify(CustomerOrder order) {
        return OrderRepo.save(order);
    }

    @Override
    public void DeleteById(Long orderId) {
        OrderRepo.deleteById(orderId);
    }

    @Override
    public List<CustomerOrder> findCustomerOrdersByProductNameContains(String productName) {
        return OrderRepo.findCustomerOrdersByProductNameContains(productName);
    }

    @Override
    public List<CustomerOrder> findCustomerOrdersByProductNameAndPrice(String pname, double price) {
        return OrderRepo.findCustomerOrdersByProductNameAndPrice(pname,price);
    }

    @Override
    public List<CustomerOrder> findByOrderByProductNameAsc() {
        return OrderRepo.findByOrderByProductNameAsc();
    }

    @Override
    public List<CustomerOrder> findByOrderByProductNameAscPriceDesc() {
        return OrderRepo.findByOrderByProductNameAscPriceDesc();
    }

    @Override
    public List<CustomerOrder> findCustomerOrdersByCust(Customer customer) {
        return OrderRepo.findCustomerOrdersByCust(customer);
    }

    @Override
    public List<CustomerOrder> findCustomerOrdersByCust_CustomerId(Long customerId) {
        return OrderRepo.findCustomerOrdersByCust_CustomerId(customerId);
    }
}
