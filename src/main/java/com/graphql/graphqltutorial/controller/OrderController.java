package com.graphql.graphqltutorial.controller;

import com.graphql.graphqltutorial.entity.Order;
import com.graphql.graphqltutorial.entity.User;
import com.graphql.graphqltutorial.service.OrderService;
import com.graphql.graphqltutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    //createOrder
    //createOrder(orderDate: String,orderPrice: Float,orderDescription: String,id: ID!): Order
    @MutationMapping
    public Order createOrder( @Argument String orderDate, @Argument Double orderPrice, @Argument String orderDescription, @Argument Integer id){
        User user=userService.getUserById(id);

        Order order=new Order();
        order.setOrderDate(orderDate);
        order.setOrderPrice(orderPrice);
        order.setOrderDescription(orderDescription);
        order.setUser(user);

        return orderService.createOrder(order);
    }

    //deleteOrder
    @MutationMapping
    public Boolean deleteOrder(@Argument Integer orderId){
        return orderService.deleteOrder(orderId);
    }

    //getAllOrders
    @QueryMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    //getOrderById
    @QueryMapping
    public Order getOrderById(@Argument Integer orderId){
        return orderService.getOrderById(orderId);
    }
}
