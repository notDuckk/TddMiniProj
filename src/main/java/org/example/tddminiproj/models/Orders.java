package org.example.tddminiproj.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    private LocalDate orderDate;

    @NotBlank(message = "Shipping address is required")
    private String shippingAddress;

    @Min(value = 0, message = "Total must be a positive value")
    private Double total;


    public Orders(Long id, String customerName, LocalDate orderDate, String shippingAddress, Double total) {
        this.id = id;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.total = total;
    }


    public Orders() {

    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Double getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
