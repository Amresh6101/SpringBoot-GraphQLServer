package com.graphql.graphqltutorial.service;


import com.graphql.graphqltutorial.entity.Order;
import com.graphql.graphqltutorial.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //getAllOrders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //getOrderById
    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order id not exist"));
    }

    // createOrder
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    //deleteOrder
    public boolean deleteOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order id not exist,enter existing id to delete"));
        orderRepository.delete(order);
        return true;
    }
}
