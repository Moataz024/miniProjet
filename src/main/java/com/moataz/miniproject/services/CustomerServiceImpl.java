package com.moataz.miniproject.services;

import com.moataz.miniproject.entities.Customer;
import com.moataz.miniproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository CustRepo;


    @Override
    public List<Customer> findCustomersByCustomerName(String customerName) {
        return CustRepo.findCustomersByCustomerName(customerName);
    }

    @Override
    public List<Customer> findAll() {
        return CustRepo.findAll();
    }

    @Override
    public Customer Create(Customer customer) {
        return CustRepo.save(customer);
    }

    @Override
    public Customer Modify(Customer customer) {
        return CustRepo.save(customer);
    }

    @Override
    public void DeleteById(Long customerId) {
         CustRepo.deleteById(customerId);
    }

    @Override
    public List<Customer> findCustomersByCustomerNameContains(String customerName) {
        return CustRepo.findCustomersByCustomerNameContains(customerName);
    }


}
