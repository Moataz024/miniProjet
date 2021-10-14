package com.moataz.miniproject.repositories;

import com.moataz.miniproject.entities.Customer;
import com.moataz.miniproject.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Query("select o from CustomerOrder o where o.productName like %?1 and o.price > ?2")
    List<CustomerOrder> findCustomerOrdersByProductNameAndPrice(@Param("productName")String productName,@Param("price")double price);
    @Query("select o from CustomerOrder o where o.productName = ?1")
    List<CustomerOrder> findCustomerOrdersByProductName(@Param("productName")String productName);
    @Query("select o from CustomerOrder o order by o.productName ASC")
    List<CustomerOrder> findByOrderByProductNameAsc();
    @Query("select o from CustomerOrder o where o.productName like %?1")
    List<CustomerOrder> findCustomerOrdersByProductNameContains(@Param("productName") String productName);
    @Query("select o from CustomerOrder o order by o.productName ASC, o.price DESC")
    List<CustomerOrder> findByOrderByProductNameAscPriceDesc();
    @Query("select o from CustomerOrder o where o.cust = ?1")
    List<CustomerOrder> findCustomerOrdersByCust(Customer customer);
    @Query("select o from CustomerOrder o where o.cust.customerId = ?1")
    List<CustomerOrder> findCustomerOrdersByCust_CustomerId(Long customerId);

}