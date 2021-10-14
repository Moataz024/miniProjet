package com.moataz.miniproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.moataz.miniproject.entities.Customer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String productName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date orderDate;
    private double price;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customerId")
    private Customer cust;


}
