package com.moataz.miniproject;

import com.moataz.miniproject.entities.Customer;
import com.moataz.miniproject.entities.CustomerOrder;
import com.moataz.miniproject.repositories.CustomerOrderRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MiniprojectApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    CustomerOrderRepository OrderRepo;
    @Test
    public void testFindByNomProduit()
    {
        List<CustomerOrder> orders = OrderRepo.findCustomerOrdersByProductName("SOURIS RAZER");

        for (CustomerOrder o : orders)
        {
            System.out.println(o);
        }

    }
    @Test
    public void testFindByNomProduitContains ()
    {
        List<CustomerOrder> orders= OrderRepo.findCustomerOrdersByProductNameContains("PC ASUS");

        for (CustomerOrder p : orders)
        {
            System.out.println(p);
        }
    }
    @Test
    public void testfindByNomPrix()
    {
        List<CustomerOrder> orders = OrderRepo.findCustomerOrdersByProductNameAndPrice("PC ASUS", 2000);
        for (CustomerOrder order : orders)
        {
            System.out.println(order);
        }

    }
    @Test
    public void testfindByCategorie()
    {
        Customer cust = new Customer();
        cust.setCustomerId(1L);
        List<CustomerOrder> orders = OrderRepo.findCustomerOrdersByCust(cust);
        for (CustomerOrder order : orders)
        {
            System.out.println(order);
        }

    }
    @Test
    public void findByCategorieIdCat()
    {
        List<CustomerOrder> orders = OrderRepo.findCustomerOrdersByCust_CustomerId(1L);
        for (CustomerOrder order : orders)
        {
            System.out.println(order);
        }

    }
    @Test
    public void testfindByOrderByNomProduitAsc()
    {
        List<CustomerOrder> orders = OrderRepo.findByOrderByProductNameAsc();
        for (CustomerOrder order : orders)
        {
             System.out.println(order);
        }

    }

}
