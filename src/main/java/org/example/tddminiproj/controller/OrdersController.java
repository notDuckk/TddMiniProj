package org.example.tddminiproj.controller;

import jakarta.validation.Valid;
import org.example.tddminiproj.models.Orders;
import org.example.tddminiproj.repos.OrdersRepo;
import org.example.tddminiproj.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        Orders orders = ordersService.getOrderById(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Orders> createOrder(@Valid @RequestBody Orders order) {
        Orders savedOrder = ordersService.addOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id, @Valid @RequestBody Orders orderDeets) {
        Orders order = ordersService.getOrderById(id);
        order.setCustomerName(orderDeets.getCustomerName());
        order.setOrderDate(orderDeets.getOrderDate());
        order.setShippingAddress(orderDeets.getShippingAddress());
        order.setTotal(orderDeets.getTotal());
        Orders updatedOrder = ordersService.addOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable Long id) {
        ordersService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}