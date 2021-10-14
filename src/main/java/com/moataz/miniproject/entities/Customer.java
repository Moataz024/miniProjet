package com.moataz.miniproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String customerAddress;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    @JsonIgnore
    @OneToMany(mappedBy = "cust",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CustomerOrder> customerOrders;


}
