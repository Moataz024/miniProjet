package com.moataz.miniproject.repositories;

import com.moataz.miniproject.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.customerName = ?1")
    List<Customer> findCustomersByCustomerName(String customerName);
    @Query("select c from Customer c where c.customerName like %?1")
    List<Customer> findCustomersByCustomerNameContains(String name);



}