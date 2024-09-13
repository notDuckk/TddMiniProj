package org.example.tddminiproj.service;


import org.example.tddminiproj.models.Orders;
import org.example.tddminiproj.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepo ordersRepo;

    public List<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }

    public Orders getOrderById(Long id) {
        return ordersRepo.findById(id).orElseThrow(()-> new RuntimeException("Order not found"));
    }

    public Orders addOrder(Orders order) {
        return ordersRepo.save(order);
    }

    public void deleteOrderById(Long id) {
        ordersRepo.deleteById(id);
    }




}
