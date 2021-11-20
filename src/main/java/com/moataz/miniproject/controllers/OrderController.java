package com.moataz.miniproject.controllers;


import com.moataz.miniproject.entities.Customer;
import com.moataz.miniproject.entities.CustomerOrder;
import com.moataz.miniproject.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order/api")
@CrossOrigin
public class OrderController {

        @Autowired
        OrderServiceImpl OrderService;
        @RequestMapping(method = RequestMethod.GET)
        public List<CustomerOrder> getAllOrders() {
            return OrderService.findAll();
        }


        @RequestMapping(value="/{orderId}",method = RequestMethod.GET)
        public CustomerOrder getOrderById(@PathVariable("orderId") Long id) {
            return OrderService.findById(id);
        }


    @RequestMapping(method = RequestMethod.POST)
    public CustomerOrder createOrder(@RequestBody CustomerOrder order) {
        return OrderService.Create(order);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public CustomerOrder updateOrder(@RequestBody CustomerOrder order) {
        return OrderService.Modify(order);
    }
    @RequestMapping(value="/{orderId}",method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable("orderId") Long id)
    {
        OrderService.DeleteById(id);
    }
    @RequestMapping(value="/custorder/{customerId}",method = RequestMethod.GET)
    public List<CustomerOrder> getOrdersByCatId(@PathVariable("customerId") Long customerId) {
        return OrderService.findCustomerOrdersByCust_CustomerId(customerId);
    }
}

