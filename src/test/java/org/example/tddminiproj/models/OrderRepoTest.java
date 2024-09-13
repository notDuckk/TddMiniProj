package org.example.tddminiproj.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.example.tddminiproj.repos.OrdersRepo;
import org.example.tddminiproj.models.Orders;
import org.springframework.test.util.AssertionErrors;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class OrderRepoTest {

    @Autowired
    private OrdersRepo orderRepo;

    private Orders order;

    @BeforeEach
    void setUp() {
        order = new Orders();
        order.setCustomerName("John Doe");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("123 Main St");
        order.setTotal(250.75);
    }

    @Test
    public void testSaveOrder() {
        Orders savedOrder = orderRepo.save(order);

        assertNotNull(savedOrder.getId());
        assertEquals("John Doe", savedOrder.getCustomerName());
    }

    @Test
    public void testDeleteOrder() {
        Orders savedOrder = orderRepo.save(order);
        orderRepo.deleteById(savedOrder.getId());
        Optional<Orders> deletedOrder = orderRepo.findById(savedOrder.getId());
        assertFalse(deletedOrder.isPresent());
    }

    @Test
    public void testGetAllOrders() {
        orderRepo.save(order);
        List<Orders> allOrders = orderRepo.findAll();
        assertNotNull(allOrders);
    }


}