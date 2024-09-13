package org.example.tddminiproj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.tddminiproj.models.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateOrder() throws Exception {
        Orders order = new Orders();
        order.setCustomerName("John Doe");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("123 Main St");
        order.setTotal(250.75);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName").value("John Doe"));
    }

    @Test
    void testGetOrderById() throws Exception {
        // Assuming an order with ID 1 exists in the database
        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.customerName").value("John Doe"));
    }

    @Test
    void testUpdateOrder() throws Exception {
        Orders updatedOrder = new Orders();
        updatedOrder.setCustomerName("Jane Doe");
        updatedOrder.setOrderDate(LocalDate.now());
        updatedOrder.setShippingAddress("456 Main St");
        updatedOrder.setTotal(300.50);

        mockMvc.perform(put("/api/orders/1") // Assuming ID 1 exists
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedOrder)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("Jane Doe"));
    }

    @Test
    void testDeleteOrder() throws Exception {
        mockMvc.perform(delete("/api/orders/1")) // Assuming ID 1 exists
                .andExpect(status().isNoContent());
    }
}