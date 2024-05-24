package com.bookstore.orderService.controller;

import com.bookstore.orderService.model.OrderModel;
import com.bookstore.orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping
    public String createOrder(@RequestBody OrderModel order){
        return service.createOrder(order);
    }

    @GetMapping("/{id}")
    public OrderModel getOrderDetails(@PathVariable int id){
        return service.getOrderDetails(id);
    }

}
